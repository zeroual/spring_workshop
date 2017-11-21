import com.zenika.ApplicationConfig;
import com.zenika.PublicationService;
import com.zenika.Story;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicationServiceTest {


    private PublicationService publicationService;

    @Before
    public void initialise() {
        System.setProperty("spring.profiles.active", "dev");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        publicationService = context.getBean(PublicationService.class);
    }

    @Test
    public void shouldPublishAStory(){
        //GIVEN
        Story hello = new Story("Hello");
        //WHEN
        publicationService.publish(hello);
        //THEN
        List<Story> feed = publicationService.getAll();
        Assert.assertEquals(1,feed.size());
        Assert.assertEquals(feed.get(0),hello);

        assertThat(feed).containsExactly(hello);

    }
}
