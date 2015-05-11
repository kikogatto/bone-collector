package br.com.keepitsimple.bonecollector.resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import io.dropwizard.testing.junit.ResourceTestRule;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import br.com.keepitsimple.bonecollector.repositories.UsageRepository;
import br.com.keepitsimple.bonecollector.representation.Usage;

public class UsageResourceTest {

	private static final UsageRepository repository = mock(UsageRepository.class);
	
	private Usage usage;
	
	@ClassRule
	public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(new UsageResource(repository)).build();
	
	@Before
	public void setup() {
		usage = new Usage();
		usage.setApplicationKey("MyAppKey");
		usage.setDuration(20000l);
		usage.setUserId("MyUserId");
		usage.setUse("Some interesting path");
		usage.setUseTime( new DateTime());
		
	}
	
    @After
    public void tearDown() {
        reset(repository);
    }
    
	@Test
	public void testLog() {
		when(repository.saveOrUpdate(any(Usage.class))).thenReturn(usage);
		
		final Response response = resources.client().target("/usage")
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(usage, MediaType.APPLICATION_JSON));

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
    }

	@SuppressWarnings("unchecked")
    @Test
	public void testListAll() {	    
	    when(repository.findAll()).thenReturn( new ArrayList<Usage>());
        final List<Usage> all =(List<Usage>) resources.client().target("/usage")
        .request(MediaType.APPLICATION_JSON)
        .get(List.class);

		assertTrue(all.isEmpty());
	}

}
