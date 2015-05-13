package org.dashbuillder.remote.services.rest;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

/**
 * Created by diogopontual on 12/05/15.
 */
public class HttpHeaders implements javax.ws.rs.core.HttpHeaders {
    private Map<String, List<String>> headers = new HashMap<String, List<String>>();

    @Override
    public List<String> getRequestHeader(String name) {
        return headers.get(name);
    }

    @Override
    public MultivaluedMap<String, String> getRequestHeaders() {
        return null;
    }

    @Override
    public List<MediaType> getAcceptableMediaTypes() {
        return null;
    }

    @Override
    public List<Locale> getAcceptableLanguages() {
        return null;
    }

    @Override
    public MediaType getMediaType() {
        return null;
    }

    @Override
    public Locale getLanguage() {
        return null;
    }

    @Override
    public Map<String, Cookie> getCookies() {
        return null;
    }

    public void putRequestHeader(String key, String value) {
        List<String> entries = headers.get(key);
        if (entries == null) {
            entries = new ArrayList<String>();
            headers.put(key, entries);
        }
        entries.add(value);
    }
}
