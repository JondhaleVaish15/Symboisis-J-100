package parlour;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

   

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_mobileno")
    private long clientMobileno;

    @Column(name = "client_password")
    private String clientPassword;

    @Column(name = "client_role")
    private String clientRole;

    @Column(name = "client_email")
    private String clientEmail;

    @ManyToMany
    @JoinTable(
        name = "clients_services",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public long getClientMobileno() {
        return clientMobileno;
    }

    public void setClientMobileno(long clientMobileno) {
        this.clientMobileno = clientMobileno;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientRole() {
        return clientRole;
    }

    public void setClientRole(String clientRole) {
        this.clientRole = clientRole;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientEmail=" + clientEmail + "]";
	}

   
}