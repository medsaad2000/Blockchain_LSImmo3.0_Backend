// SPDX-License-Identifier: MIT
pragma solidity >=0.4.20;

contract Owned {
    address public owner;

    constructor(){
        owner = msg.sender;
    }

    modifier onlyOwner {
        if (msg.sender != owner) { assert(msg.sender == owner); }
        _;
    }

    function transferOwnership(address newOwner) onlyOwner public{
        owner = newOwner;
    }
}

contract MarketPlace is Owned {

    // Custom types
    struct Immobilier {
        uint id;
        address seller;
        address buyer;
        string name;
        string description;
        string localisation;
        uint256 price;
        uint surface;
    }

    // State variables
    mapping(uint => Immobilier) public immobiliers;
    uint immobilierCounter;

    //Events
    event sellImmobilierEvent(
        uint indexed _id,
        address indexed _seller,
        string _name,
        uint256 _price,
        uint _surface);

    event buyImmobilierEvent(
        uint indexed _id,
        address indexed _seller,
        address indexed _buyer,
        string _name,
        uint256 _price,
        uint _surface);


    //sell an article
    function sellImmobilier(string memory _name, string memory _description,string memory _localisation, uint256 _price,uint _surface) public {
        // a new article
        immobilierCounter++;

        //store this article
        immobiliers[immobilierCounter] = Immobilier(
            immobilierCounter,
            msg.sender,
            0x0000000000000000000000000000000000000000,
            _name,
            _description,
            _localisation,
            _price,
            _surface
        );

        // trigger the event
        emit sellImmobilierEvent(immobilierCounter, msg.sender, _name, _price,_surface);
    }

    // fetch the number of articles in the contract
    function getNumberOfArticles() public view returns (uint) {
        return immobilierCounter;
    }

    // fetch and returns all article IDs available for sale
    function getArticlesForSale() public view returns (uint[] memory) {
        // we check whether there is at least one article
        if(immobilierCounter == 0) {
            return new uint[](0);
        }

        // prepare intermediary array
        uint[] memory articleIds = new uint[](immobilierCounter);

        uint numberOfImmobiliersForSale = 0;
        // iterate over articles
        for (uint i = 1; i <= immobilierCounter; i++) {
            // keep only the ID of articles not sold yet
            if (immobiliers[i].buyer == 0x0000000000000000000000000000000000000000) {
                articleIds[numberOfImmobiliersForSale] = immobiliers[i].id;
                numberOfImmobiliersForSale++;
            }
        }

        // copy the articleIds array into the smaller forSale array
        uint[] memory forSale = new uint[](numberOfImmobiliersForSale);
        for (uint j = 0; j < numberOfImmobiliersForSale; j++) {
            forSale[j] = articleIds[j];
        }
        return (forSale);
    }

    // buy an article
    function buyArticle(uint _id) payable public {
        // we check whether there is at least one article
        require(immobilierCounter > 0);

        // we check whether the article exists
        require(_id > 0 && _id <= immobilierCounter);

        // we retrieve the article
        Immobilier storage immobilier = immobiliers[_id];

        // we check whether the article has not already been sold
        require(immobilier.buyer == 0x0000000000000000000000000000000000000000);

        // we don't allow the seller to buy his/her own article
        require(immobilier.seller != msg.sender);



        // keep buyer's information
        immobilier.buyer = msg.sender;



        // trigger the event
        emit buyImmobilierEvent(_id, immobilier.seller, immobilier.buyer, immobilier.name, immobilier.price, immobilier.surface);
    }

    //kill the smart contract
    function kill() onlyOwner public{
        selfdestruct(payable(owner));
    }
}
