package Main;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;

@Document(collection="visitordescriptor")
public class VisitorDescriptor {

    @Id
    private String id;
    private Date timestamp;
    private String data;

    public VisitorDescriptor() {
    }

    public VisitorDescriptor(Timestamp timestamp, String data) {
        this.timestamp = timestamp;
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }


}