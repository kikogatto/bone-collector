package br.com.keepitsimple.bonecollector.representation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class UsageTest {
	@Test
	public void testUsage() {
		DateTime time = new DateTime();
		Usage usage = new Usage();
		assertNull(usage.getUse());
		assertNull(usage.getUserId());
		assertNull(usage.getUseTime());
		assertNotNull(usage.getUid());
		assertNotNull(UUID.fromString(usage.getUid()));
		assertTrue("The creation Time is properly set", usage.getCreationTime().getMillis() - time.getMillis() <1000);
	}
	
	@Test
	public void testSetGetUid() {
		Usage usage = new Usage();
		String uid = "ANiceId";
		usage.setUid(uid);
		assertSame(uid, usage.getUid());
	}
	@Test
	public void testSetGetUserId() {
		Usage usage = new Usage();
		String userId = "ANiceId";
		usage.setUserId(userId);
		assertSame(userId, usage.getUserId());
	}
	@Test
	public void testGetUse() {
		Usage usage = new Usage();
		String use = "ANiceUse";
		usage.setUse(use);
		assertSame(use, usage.getUse());
	}
	@Test
	public void testSetGetCreationTime() {
		Usage usage = new Usage();
		DateTime time = new DateTime();
		usage.setCreationTime(time);
		assertSame(time,usage.getCreationTime());
	}
	@Test
	public void testSetGetUseTime() {
		Usage usage = new Usage();
		DateTime time = new DateTime();
		usage.setUseTime(time);
		assertSame(time,usage.getUseTime());
	}
	
	@Test
	public void testSerialization() throws JsonProcessingException {
		Usage usage = new Usage();
		DateTime time = new DateTime(1430409213490l);
		usage.setUid("00001");
		usage.setUserId("cap.Vitgulino");
		usage.setCreationTime(time);
		usage.setUseTime(time);	
		usage.setUse("Testing serialization");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = mapper.writeValueAsString(usage);
		assertEquals("{\"uid\":\"00001\",\"userId\":\"cap.Vitgulino\",\"creationTime\":\"2015-04-30T15:53:33.490Z\",\"useTime\":\"2015-04-30T15:53:33.490Z\",\"use\":\"Testing serialization\"}",json);
	}
	@Test
	public void testDeserialization() throws IOException {
		Usage usage = new Usage();
		DateTime time = new DateTime(1430409213490l, DateTimeZone.UTC);
		usage.setUid("00001");
		usage.setUserId("cap.Vitgulino");
		usage.setCreationTime(time);
		usage.setUseTime(time);	
		usage.setUse("Testing serialization");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = "{\"uid\":\"00001\",\"userId\":\"cap.Vitgulino\",\"creationTime\":\"2015-04-30T15:53:33.490Z\",\"useTime\":\"2015-04-30T15:53:33.490Z\",\"use\":\"Testing serialization\"}";
		Usage deserialized = mapper.readValue(json, Usage.class);
		assertEquals(usage, deserialized);
	}
}
