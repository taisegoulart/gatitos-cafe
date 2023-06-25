import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdminCatResourceTest {

    @Mock
    private CatService catService;

    @InjectMocks
    private AdminCatResource adminCatResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCat() {
        // Mock the necessary objects
        Cat cat = new Cat("Whiskers", 2, "Female", "Siamese", "Friendly and playful", true);
        when(catService.createCat(cat)).thenReturn(cat);

        // Perform the test
        Response response = adminCatResource.createCat(cat);

        // Verify the response and service method calls
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        verify(catService).createCat(cat);
    }

    @Test
    public void testUpdateCat() {
        // Mock the necessary objects
        Cat cat = new Cat("Whiskers", 2, "Female", "Siamese", "Friendly and playful", true);
        when(catService.updateCat(cat)).thenReturn(cat);

        // Perform the test
        Response response = adminCatResource.updateCat(cat.getId(), cat);

        // Verify the response and service method calls
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(catService).updateCat(cat);
    }

    @Test
    public void testDeleteCat() {
        // Mock the necessary objects
        long catId = 1L;

        // Perform the test
        Response response = adminCatResource.deleteCat(catId);

        // Verify the response and service method calls
        Assertions.assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
        verify(catService).deleteCat(catId);
    }
}