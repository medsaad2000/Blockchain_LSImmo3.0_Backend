package ma.fstt.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class AppRole {

    @Id
    private String id;
    private String roleName;

	@DBRef
	private Collection<AppUser> users = new ArrayList();


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AppRole() {
        super();
        // TODO Auto-generated constructor stub
    }


	public Collection<AppUser> getUsers() {
		return users;
	}
	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public AppRole(String roleName) {
        super();
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AppRole [id=" + id + ", roleName=" + roleName + "]";
    }


}
