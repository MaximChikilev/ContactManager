package ua.kiev.prog.jsonloader;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.kiev.prog.Contact;

import java.util.List;

public class ContactJsonFileManager extends JasonFilesManager<Contact>{
    public ContactJsonFileManager(String path) {
        super(path);
        listType = new TypeToken<List<Contact>>() { }.getType();
        gsonForSave = new GsonBuilder()
                .registerTypeAdapter(Contact.class, new ContactSerializer())
                .create();
        gsonForLoad = new GsonBuilder()
                .registerTypeAdapter(Contact.class, new ContactDeserializer())
                .create();
        nameToSave="saveContacts.json";
        nameToLoad="loadContacts.json";
    }
}
