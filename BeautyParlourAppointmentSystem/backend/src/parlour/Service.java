package parlour;
import javax.persistence.*;



import java.util.List;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int serviceId;
    private String serviceName;
    private String serviceType;
    private double servicePrice;

    @ManyToMany//(mappedBy = "services")
    private List<Client> clients;
    @OneToMany
    private List<Appoinment>appoinmet;
    
	public List<Appoinment> getAppoinmet() {
		return appoinmet;
	}

	public void setAppoinmet(List<Appoinment> appoinmet) {
		this.appoinmet = appoinmet;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceType=" + serviceType
				+ "]";
	}


	
  
}
