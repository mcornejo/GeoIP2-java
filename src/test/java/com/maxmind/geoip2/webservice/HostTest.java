package com.maxmind.geoip2.webservice;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.junit.Test;

import com.google.api.client.http.HttpTransport;
import com.maxmind.geoip2.exception.GeoIP2Exception;
import com.maxmind.geoip2.model.OmniLookup;

public class HostTest {

    @Test
    public void omni() throws GeoIP2Exception, UnknownHostException {
        HttpTransport transport = new TestTransport();
        Client client = new Client(42, "012345689", Arrays.asList("en"),
                "blah.com", transport);

        OmniLookup omni = client.omni(InetAddress.getByName("128.101.101.101"));
        assertEquals(omni.getTraits().getIpAddress(), "128.101.101.101");
    }
}
