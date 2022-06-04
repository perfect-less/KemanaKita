
import os

import numpy as np

from tensorflow import lite as tflite
from PIL import Image

class Interpreter():
    def __init__(self, model_path="converted_model.tflite"):
        # Load the TFLite model and allocate tensors.
        self.interpreter = tflite.Interpreter(model_path)
        self.interpreter.allocate_tensors()

        # Get input and output tensors.
        self.input_details = self.interpreter.get_input_details()
        self.output_details = self.interpreter.get_output_details()

        # Test the model on random input data.
        self.input_shape = self.input_details[0]['shape']
        

    def Invoke(self, feature):
        
        input_data = np.array(feature, dtype=np.float32)
        self.interpreter.set_tensor(self.input_details[0]['index'], input_data)

        self.interpreter.invoke()

        # The function `get_tensor()` returns a copy of the tensor data.
        # Use `tensor()` in order to get a pointer to the tensor.
        output_data = self.interpreter.get_tensor(self.output_details[0]['index'])
        return np.argmax(output_data)




IMG_FOLDER = 'static'
IMG_INPUT_SIZE = (224, 224)


def run (img_path: str = None):
    intepreter = Interpreter()

    # If img_path were given
    if not img_path == None:
        image = Image.open(img_path).resize(IMG_INPUT_SIZE)
        image = np.expand_dims(np.asarray(image), axis=0)

        result = intepreter.Invoke(image)
        return result

    # If img_path is not given
    # 
    img_list = os.listdir(IMG_FOLDER)
    results = []

    for img in img_list:
        image = Image.open(os.path.join(IMG_FOLDER, img)).resize(IMG_INPUT_SIZE)
        image = np.expand_dims(np.asarray(image), axis=0)

        # print ( 'image shape: {}'.format (image.shape))

        result = intepreter.Invoke(image)
        results.append (result)
        # print ('{}: {}'.format(img, result))
    
    return img_list, results


if __name__ == "__main__":
    img_list, results = run ()

    for img, result in zip(img_list, results):
        print ('{}: {}'.format(img, result))

