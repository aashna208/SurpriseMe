package hackathon.yelp.com.surpriseme;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * The gson helper
 */
public class GsonHelper {

    public static <T> String serialize(T object, Map<Type, TypeAdapter> typeAdapters) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        if (typeAdapters != null) {
            for (Map.Entry<Type, TypeAdapter> adapterEntry : typeAdapters.entrySet()) {
                gsonBuilder.registerTypeAdapter(adapterEntry.getKey(), adapterEntry.getValue());
            }
        }
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    public static <T> T deserialize(String object, Class type, Map<Type, TypeAdapter> typeAdapters) {
        if (object == null) {
            return null;
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson;
        if (typeAdapters != null) {
            for (Map.Entry<Type, TypeAdapter> adapterEntry : typeAdapters.entrySet()) {
                gsonBuilder.registerTypeAdapter(adapterEntry.getKey(), adapterEntry.getValue());
            }
            gson = gsonBuilder.create();
        } else {
            gson = new Gson();
        }

        try {
            return (T) gson.fromJson(object, type);
        } catch (JsonParseException exception) {
            return null;
        }
    }

}

