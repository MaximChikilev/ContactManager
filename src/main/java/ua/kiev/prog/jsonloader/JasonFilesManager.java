package ua.kiev.prog.jsonloader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.Contact;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public abstract class JasonFilesManager<T> {
    protected String path;
    protected String nameToSave;
    protected String nameToLoad;
    protected Type listType;
    protected Gson gsonForSave;
    protected Gson gsonForLoad;

    public JasonFilesManager(String path) {
        this.path = path;
    }

    public List<T> loadJsonListFromFile() throws IOException {
        try (Reader reader = new FileReader(path + nameToLoad)) {
            List<T> newList = gsonForLoad.fromJson(reader, listType);
            return newList;
        }
    }

    public void saveJsonListToFile(List<T> list) throws IOException {
        String jsonString = gsonForSave.toJson(list);
        try (FileWriter fileWriter = new FileWriter(path + nameToSave)) {
            fileWriter.write(jsonString);
        }
    }
}
