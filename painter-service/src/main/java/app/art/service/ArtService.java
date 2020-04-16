package app.art.service;

import app.art.domain.Art;
import app.painter.api.art.ArtView;
import app.painter.api.art.CreateArtRequest;
import app.painter.api.art.SearchArtRequest;
import app.painter.api.art.SearchArtResponse;
import com.mongodb.ReadPreference;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.mongo.Query;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;

import java.util.UUID;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.text;

/**
 * @author charlie
 */
public class ArtService {
    @Inject
    MongoCollection<Art> artCollection;

    public ArtView get(String id) {
        Art art = artCollection.get(id).orElseThrow(() -> new NotFoundException(Strings.format("art not found, id={}", id)));
        return view(art);
    }

    public ArtView create(CreateArtRequest request) {
        Art art = new Art();
        art.id = UUID.randomUUID().toString();
        art.name = request.name;
        artCollection.insert(art);
        return view(art);
    }

    public SearchArtResponse search(SearchArtRequest request) {
        SearchArtResponse result = new SearchArtResponse();
        Query query = new Query();
        query.skip = request.skip;
        query.limit = request.limit;
        query.filter = text(request.term); // requires text index
        query.readPreference = ReadPreference.secondaryPreferred();
        result.art = artCollection.find(query).stream().map(this::view).collect(Collectors.toList());
        result.total = (long) result.art.size(); // no query.count() for mongo?
        return result;
    }

    private ArtView view(Art art) {
        ArtView artView = new ArtView();
        artView.id = art.id;
        artView.name = art.name;
        return artView;
    }
}
