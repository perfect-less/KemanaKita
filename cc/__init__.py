from flask import Flask, request, jsonify, render_template
from .inference import run
import requests
import json
import os

UPLOAD_FOLDER = os.path.join('static', 'people_photo')

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

@app.route('/', methods=["POST"])
def predict():
    imageFile = request.files["imageFile"]
    imagePath = "./static/" + imageFile.filename
    pathInference = "static/" + imageFile.filename
    imageFile.save(imagePath)

    destinationApi = requests.get('https://bangkit-6ac35-default-rtdb.asia-southeast1.firebasedatabase.app/data.json')
    destinationData = json.loads(destinationApi.text)
    
    arrayDestination = {}
    for value in destinationData:
        arrayDestination[value['id']] = value

    results = run (pathInference)

    returnData = {
        'image': pathInference,
        'destination': arrayDestination[results]
    }

    return jsonify(returnData)