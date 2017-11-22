import com.zenika.ApplicationConfig;
import com.zenika.PublicationService;
import com.zenika.Story;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("dev")
public class PublicationServiceTest {


    @Autowired
    private PublicationService publicationService;

    @Test
    public void shouldPublishAStory() {
        //GIVEN
        Story hello = new Story("Hello");
        //WHEN
        publicationService.publish(hello);
        //THEN
        List<Story> feed = publicationService.getAll();
        Assert.assertEquals(1, feed.size());
        Assert.assertEquals(feed.get(0), hello);

        assertThat(feed).containsExactly(hello);

    }
}
