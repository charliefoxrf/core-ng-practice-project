package app.art.job;

import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author charlie
 */
public class ArtFixedJob implements Job {
    private final Logger logger = LoggerFactory.getLogger(ArtFixedJob.class);

    @Override
    public void execute(JobContext context) throws Exception {
        logger.info("Running art fixed job!");
    }
}
