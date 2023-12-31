package ua.kiev.prog.jsonloader;

import com.google.gson.*;
import ua.kiev.prog.Contact;
import ua.kiev.prog.Group;

import java.lang.reflect.Type;

public class ContactDeserializer implements JsonDeserializer<Contact> {
    @Override
    public Contact deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Long id = jsonObject.getAsJsonPrimitive("id").getAsLong();
        String name = jsonObject.getAsJsonPrimitive("name").getAsString();
        String surname = jsonObject.getAsJsonPrimitive("surname").getAsString();
        String phone = jsonObject.getAsJsonPrimitive("phone").getAsString();
        String email = jsonObject.getAsJsonPrimitive("email").getAsString();

        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setEmail(email);

        // Deserialize group ID and set it in the contact
        if (jsonObject.has("groupName")) {
            String groupName = jsonObject.getAsJsonPrimitive("groupName").getAsString();
            Group group = new Group();
            group.setName(groupName);
            contact.setGroup(group);
        }

        return contact;
    }
}
