package app.art.service;

import app.art.domain.Art;
import app.painter.api.art.ArtView;
import app.painter.api.art.CreateArtRequest;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.web.exception.NotFoundException;

import java.util.UUID;

/**
 * @author charlie
 */
//todo you can make some cases for query
// Query query = new Query();
// and we usually use ReadPreference.secondary() to query
public class ArtService {
    @Inject
    MongoCollection<Art> artCollection;

    public ArtView get(String id) {
        Art art = artCollection.get(id).orElseThrow(() -> new NotFoundException("art not found, id=" + id));
        return view(art);
    }

    public ArtView create(CreateArtRequest request) {
        Art art = new Art();
        art.id = UUID.randomUUID().toString();
        art.name = request.name;
        artCollection.insert(art);
        return view(art);
    }

    private ArtView view(Art art) {
        ArtView artView = new ArtView();
        artView.id = art.id;
        artView.name = art.name;
        return artView;
    }
}
