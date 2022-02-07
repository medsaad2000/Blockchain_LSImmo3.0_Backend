package ma.fstt.service;

import lombok.extern.slf4j.Slf4j;
import ma.fstt.contracts.Src_main_resources_solidity_MarketPlace_sol_MarketPlace;
import ma.fstt.entity.Immobilier;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

@Slf4j
@Service
public class ContratService {
    Src_main_resources_solidity_MarketPlace_sol_MarketPlace contrat1 ;

    private static String CONTRACT_ADDRESS ="0x24f5c35D78F13AE0823C171454A27a72662B8b8b" ;

    Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    String privatekey = "e328d7cfb7fc7d74c43778e8455c1c6f037522d2e4553762dea4f579a85f1657";
    BigInteger privkey = new BigInteger(privatekey, 16);
    ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
    Credentials credentials = Credentials.create(ecKeyPair);
    TransactionManager transactionManager =new ClientTransactionManager(web3j , "d2601389278084ab26c608563dfb89f6063ed4d13822e607ab1ed7e3e4710290");

    //Deploy contrat
    public String deployContrat(){
        try {
            this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.deploy(web3j,credentials,GAS_PRICE,GAS_LIMIT).send();
            this.CONTRACT_ADDRESS = contrat1.getContractAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.CONTRACT_ADDRESS;
    }


    //Add Immobilier and sell
    public void sellImmobilier(String _name, String _description,String _localisation, BigInteger _price , BigInteger _surface , String privateKey1) throws Exception {
        BigInteger privkey = new BigInteger(privateKey1, 16);
        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
        Credentials credentials = Credentials.create(ecKeyPair);
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        this.contrat1.sellImmobilier(_name,_description,_localisation,_price,_surface).send();

    }


    //Afficher le nombre des articles
    public void afficherNombreImmobilier(){
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        try {
            log.warn("Nombre des articles   : "+this.contrat1.getNumberOfArticles().send());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Get le nombre des articles
    public int getNombreImmobilier(){
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        try {
            log.warn("Nombre des articles   : "+this.contrat1.getNumberOfArticles().send());
            return this.contrat1.getNumberOfArticles().send().intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    //Get un immobilier
    public Immobilier getImmobilier(long id){
        Immobilier imm = new Immobilier();
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        try{
            Tuple8 tp =this.contrat1.immobiliers(BigInteger.valueOf(id)).send();
            imm.setId((BigInteger) tp.component1());
            imm.setName((String) tp.component4());
            imm.setDescription((String) tp.component5());
            imm.setLocalisation((String) tp.component6());
            imm.setOwnerAddress((String) tp.component2());
            imm.setBuyerAddress((String) tp.component3());
            imm.setPrice((BigInteger) tp.component7());
            imm.setSurface((BigInteger) tp.component8());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return imm;

    }

    //Acheter un immobiler
    public void buyImmobilier(long id) throws Exception {
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        this.contrat1.buyArticle(BigInteger.valueOf(id)).send();

    }

    public void buyImmobilierWithTransfer(long id , String privateKey1) throws Exception {
        BigInteger privkey = new BigInteger(privateKey1, 16);
        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
        Credentials credentials1 = Credentials.create(ecKeyPair);
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials1,GAS_PRICE,GAS_LIMIT);
        this.contrat1.buyArticle(BigInteger.valueOf(id)).send();
    }

    //Get tous les articles
    public ArrayList<Immobilier> getAllImmobilier (){
        this.contrat1 = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        ArrayList<Immobilier> immobiliers = new ArrayList<Immobilier>();
        try {
            for(int i= this.contrat1.getNumberOfArticles().send().intValue();i>0;i--){
                immobiliers.add(getImmobilier(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  immobiliers ;
    }

    public void transferEther (String privateKeyBuyer , String addressOwner, int price){
        BigInteger privkey = new BigInteger(privateKeyBuyer, 16);
        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
        Credentials credentialsBuyer = Credentials.create(ecKeyPair);
        try {
            TransactionReceipt transactionReceipt = Transfer.sendFunds(
                    web3j, credentialsBuyer,addressOwner ,
                    BigDecimal.valueOf(price,0), Convert.Unit.ETHER).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
