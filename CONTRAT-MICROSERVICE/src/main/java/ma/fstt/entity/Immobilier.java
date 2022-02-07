package ma.fstt.entity;

import java.math.BigInteger;

public class Immobilier {
        BigInteger id ;
        String ownerAddress ;
        String buyerAddress ;
        String name;
        String description;
        String localisation;
        BigInteger surface;
        BigInteger price;

    public Immobilier(){
        super();
    }

    public Immobilier(String ownerAddress, String name, String description,String localisation, BigInteger surface, BigInteger price) {
        this.ownerAddress = ownerAddress;
        this.name = name;
        this.description = description;
        this.surface = surface;
        this.price = price;
    }


    public Immobilier(BigInteger id , String ownerAddress, String name, String description,String localisation, BigInteger surface, BigInteger price) {
        this.id=id;
        this.ownerAddress = ownerAddress;
        this.name = name;
        this.description = description;
        this.surface = surface;
        this.price = price;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getSurface() {
        return surface;
    }

    public void setSurface(BigInteger surface) {
        this.surface = surface;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }
}
