package com.example.demo.model;

//@Entity
public class PackageService {

//	@Id
//	@GeneratedValue
	private long serviceId;
	private String serviceName;
	private String serviceValue;
	private String serviceDescription;
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceValue() {
		return serviceValue;
	}
	public void setServiceValue(String serviceValue) {
		this.serviceValue = serviceValue;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	@Override
	public String toString() {
		return "PackageServices [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceValue="
				+ serviceValue + ", serviceDescription=" + serviceDescription + "]";
	}
	
}
