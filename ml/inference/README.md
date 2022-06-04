# Inference Module

To use this module you must put images you want to infer using the model on `images` folder. Then you can either run the inference with:

```bash
$ python3 inference.py
```

or importing it and running it through other python module

```
import inference
inference.run('images/file-name.jpeg')
```

if you call run method without any parameters
```
inference.run()
```
it will run as if you run ith with the first method.