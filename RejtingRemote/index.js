/**
 * Copyright 2016, Google, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

'use strict';

const Datastore = require('@google-cloud/datastore');

// Instantiates a client
const datastore = Datastore();
/*const ds = Datastore({
  //projectId: config.get('GCLOUD_PROJECT')
  projectId: 'rejting-remote'
});*/

const kind="Recenzija2";
/**
 * Gets a Datastore key from the kind/key pair in the request.
 *
 * @param {object} requestData Cloud Function request data.
 * @param {string} requestData.key Datastore key string.
 * @param {string} requestData.kind Datastore kind.
 * @returns {object} Datastore key object.
 */
function getKeyFromRequestData (requestData) {
	console.log("telo je:"+ JSON.stringify(requestData.body));
  if (!requestData.body.id) {
    throw new Error('Key not provided. Make sure you have a "key" property in your request');
  }


  return datastore.key([kind, requestData.body.id]);
}

/**
 * Creates and/or updates a record.
 *
 * @example
 * gcloud functions call set --data '{"kind":"Task","key":"sampletask1","value":{"description": "Buy milk"}}'
 *
 * @param {object} req Cloud Function request context.
 * @param {object} req.body The request body.
 * @param {string} req.body.kind The Datastore kind of the data to save, e.g. "Task".
 * @param {string} req.body.key Key at which to save the data, e.g. "sampletask1".
 * @param {object} req.body.value Value to save to Cloud Datastore, e.g. {"description":"Buy milk"}
 * @param {object} res Cloud Function response context.
 */
 
 // Datastore format:
//   {
//     key: [kind, id],
//     data: {
//       property: value
//     }
//   }

exports.set = (req, res) => {
  // The value contains a JSON document representing the entity we want to save
  console.log("izmenjen set");
  if (!req.body) {
    throw new Error('Value not provided. Make sure you have a "value" property in your request');
  }

  const key = getKeyFromRequestData(req);
  const entity = {
    key: key,
    data: req.body
  };

  return datastore.save(entity)
    .then(() => res.status(200).send(`Entity ${key.path.join('/')} saved.`))
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
};

exports.get = (req, res) => {
  //const key = getKeyFromRequestData(req.body);
  console.log("izmenjeno");
  let id = req.query.id
  const key=datastore.key([kind,id]);
  
  return datastore.get(key)
    .then(([entity]) => {
      // The get operation will not fail for a non-existent entity, it just
      // returns an empty dictionary.
      if (!entity) {
        throw new Error(`No entity found for key ${key.path.join('/')}.`);
      }

      res.status(200).send(entity);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
};

exports.getAll = (req, res) => {
  //const key = getKeyFromRequestData(req.body);
    const query = datastore.createQuery(kind);
	datastore.runQuery(query).then(results => {
		console.log("query pokrenut");
		console.log(results);
	  const recenzije = results[0];
	  res.status(200).send(JSON.stringify(recenzije));
	  //res.sendStatus(200);
	})
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
};

exports.findByNotAllowed = (req, res) => {
  //const key = getKeyFromRequestData(req.body);
	let allowed=req.query.allowed=='true'
    const query = datastore.createQuery(kind).filter('komentar.odobren','=',allowed);
	datastore.runQuery(query).then(results => {
		console.log("query pokrenut");
		console.log(results);
	  const recenzije = results[0];
	  res.status(200).send(JSON.stringify(recenzije));
	  //res.sendStatus(200);
	})
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
};

exports.calculateAverageRejtingForSmestaj = (req, res) => {
  let filter=req.query.filter;;
  let value=req.query.value
  let averageVal=0;
  let br=0;
  const query = datastore.createQuery(kind).filter(filter,'=',value);
  
	datastore.runQuery(query).then(results => {
		console.log("query pokrenut");
		console.log(results);
	  const recenzije = results[0];
	  console.log("pojedinacne");
	  recenzije.forEach(recenzija => {
		  averageVal=recenzija.ocena+averageVal
		  br=br+1;
	  });
	  
	  res.status(200).send(JSON.stringify(averageVal/br));
	  //res.sendStatus(200);
	})
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
		
};

exports.findBySmestajAndRejting = (req, res) => {
  let ocena = parseInt(req.query.ocena);
  let smestajId=req.query.smestajId;
  const query = datastore.createQuery(kind).filter('ocena','=',ocena).filter('smestajId','=',smestajId);
  
	datastore.runQuery(query).then(results => {
		console.log("query pokrenut");
		console.log(results);
	  const recenzije = results[0];	  
	  res.status(200).send(JSON.stringify(recenzije));
	  //res.sendStatus(200);
	})
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
		
};

exports.approve = (req, res) => {
  //const key = getKeyFromRequestData(req.body);
  console.log("izmenjeno");
  let id = req.query.id
  const key=datastore.key([kind,id]);
  
  return datastore.get(key)
    .then(([entity]) => {
      // The get operation will not fail for a non-existent entity, it just
      // returns an empty dictionary.
      if (!entity) {
        throw new Error(`No entity found for key ${key.path.join('/')}.`);
      }
		entity.komentar.odobren=true;
		datastore.save(entity);
      res.status(200).send(entity);
    })
    .catch((err) => {
      console.error(err);
      res.status(500).send(err.message);
      return Promise.reject(err);
    });
};


exports.helloHttp = function helloHttp(req, res) {
  
  // Example input: ?name=Pera or {"name": "Pera"}
  let name = req.query.name || req.body.name;
  
  if (name === undefined) {
    // This is an error case, as "name" is required.
    console.warn('Bad request: No name provided.');
    res.status(400).send('Name is not defined!');
  } else {
    // Everything is okay.
    console.log('Sending a greeting to: ' + name);
    res.status(200).send('Hello ' + name + '!');
  }
};
