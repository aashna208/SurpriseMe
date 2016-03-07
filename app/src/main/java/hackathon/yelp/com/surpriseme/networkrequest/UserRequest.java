package hackathon.yelp.com.surpriseme.networkrequest;

import com.google.gson.TypeAdapter;

import java.lang.reflect.Type;
import java.util.Map;

public class UserRequest<T> {

    public UserRequest(String url, Class<T> classType, Map<Type, TypeAdapter> typeAdapters) {
        this.url = url;
        this.classType = classType;
        this.typeAdapters = typeAdapters;
    }

    public String url;

    public Class<T> classType;

    public Map<Type, TypeAdapter> typeAdapters;
}
