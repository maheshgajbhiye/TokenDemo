# TokenDemo application provide API's only, which is in below sequence-
  (foreign key's maintain accordingly)

1. To add customer priority -
  Methode - Post
  API - http://localhost:8080/customer/addPriority
  Data - {"id":"1","type":"PLATINUM"}
  
2. To add customer details -
  Methode - Post
  API - http://localhost:8080/customer/create
  Data - {"name":"test1","accountNumber":"111100001","priorityId":"1"}

3. To generate token -
    Methode - Get
    API - http://localhost:8080/token/generate/111100001
    (111100001 is account number of customer)

4. To get token to the banker and display, as per counter number -
    Methode - Get
    API - http://localhost:8080/token/next/1
    (1 is counter number)

5. To update token as served/close -
    Methode - Get
    API - http://localhost:8080/token/update/1/CLOSE
    (here: 1 is token id and close is status)

# status enum define as below 
  ACTIVE("A"), PROCESSING("P"), ONHOLD("H"), CLOSE("C");
  
# cloud DB  
https://console.scalegrid.io/MySQLClusters/855/clusterDetails
(will send username password on mail) 

Note: you will need to add your machine's public IP address to firewall on cloud DB. 

1. Login to above link
2. click on mysql tab on left
3. click on overview. 
4. click on firewll rule add your public ip

# DB scema is in MySQL-script folder


