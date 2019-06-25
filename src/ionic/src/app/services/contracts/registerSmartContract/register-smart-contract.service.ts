import { Injectable, ɵConsole } from '@angular/core';
import { Platform } from '@ionic/angular';
import Web3 from 'web3';

@Injectable({
  providedIn: 'root'
})
export class RegisterSmartContractService {

  web3: any;
  urlProvider: string;
  contract: any;
  jsonContract: any;
  hashContract: any;

  constructor(
    private platform: Platform
  ) {
    this.urlProvider = 'http://192.168.0.5:8545';
    this.create();
  }

  private create() {

  }

  register(billetera: string, jsonContract: string, hashContract: string, name: string, age: number, personType: boolean) {
    this.platform.ready().then(dataP => {

      //const web3 = new Web3(this.urlProvider, null, options);
      const web3 = new Web3(new Web3.providers.HttpProvider(this.urlProvider));
      // const web3 = new Web3(Web3.givenProvider || this.urlProvider);
      if (!web3.currentProvider) {
        web3.setProvider(this.urlProvider);
      }

      web3.eth.defaultAccount = web3.eth.accounts[0];

      const localJson = web3.eth.contract([
        {
          "anonymous": false,
          "inputs": [
            {
              "indexed": false,
              "name": "name",
              "type": "string"
            },
            {
              "indexed": false,
              "name": "age",
              "type": "uint256"
            },
            {
              "indexed": false,
              "name": "personType",
              "type": "bool"
            }
          ],
          "name": "Instructor",
          "type": "event"
        },
        {
          "constant": false,
          "inputs": [
            {
              "name": "_fName",
              "type": "string"
            },
            {
              "name": "_age",
              "type": "uint256"
            },
            {
              "name": "_personType",
              "type": "bool"
            }
          ],
          "name": "setInstructor",
          "outputs": [],
          "payable": false,
          "stateMutability": "nonpayable",
          "type": "function"
        },
        {
          "constant": true,
          "inputs": [],
          "name": "getInstructor",
          "outputs": [
            {
              "name": "",
              "type": "string"
            },
            {
              "name": "",
              "type": "uint256"
            },
            {
              "name": "",
              "type": "bool"
            }
          ],
          "payable": false,
          "stateMutability": "view",
          "type": "function"
        }
      ]);

      // const auxJsonContract = JSON.parse(jsonContract);
      this.contract = localJson.at(hashContract);
      console.log(this.contract);
      const aux = this.contract.getInstructor();
      console.log(aux);

      const edad = 28;
      console.log(edad);
      this.contract.setInstructor(name, age, personType);
      console.log(this.hashContract);

    });

  }
}
