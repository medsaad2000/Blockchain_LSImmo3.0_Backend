package ma.fstt;

import lombok.extern.slf4j.Slf4j;
import ma.fstt.contracts.Src_main_resources_solidity_MarketPlace_sol_MarketPlace;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@SpringBootApplication @Slf4j
@EnableFeignClients
@CrossOrigin(origins = "*")
public class ContratMicroServiceApplication implements CommandLineRunner {
    //    Declare GAS Limit From Ganache :
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975);

    //    Declare GAS Price From Ganache
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    //     Declare Contract Address
    private final static String CONTRACT_ADDRESS = "0x24f5c35d78f13ae0823c171454a27a72662b8b8b";

    public static void main(String[] args) {
        SpringApplication.run(ContratMicroServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));
//        String privatekey = "e328d7cfb7fc7d74c43778e8455c1c6f037522d2e4553762dea4f579a85f1657";
//        BigInteger privkey = new BigInteger(privatekey, 16);
//        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
//        Credentials credentials = Credentials.create(ecKeyPair);
//        // Deployer smart contract :
//        //Src_main_resources_solidity_MarketPlace_sol_MarketPlace contract = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.deploy(web3j,credentials,GAS_PRICE,GAS_LIMIT).send();
//        //log.warn(contract.getContractAddress());
//
//        Src_main_resources_solidity_MarketPlace_sol_MarketPlace contract = Src_main_resources_solidity_MarketPlace_sol_MarketPlace.load(CONTRACT_ADDRESS,web3j,credentials,GAS_PRICE,GAS_LIMIT);


    }

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/*").allowedOrigins("http://localhost:4200");
            }
        };
    }

}

