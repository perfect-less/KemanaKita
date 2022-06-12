# Android Section
This is Mobile Development Section of this repo. Written here are information about what this android studio project needed and how it works conceptually.

## Dependencies
Listed bellow are required library for this android studio project.
1. Camera library
2. Kotlin parcelize
3. Retrofit
4. Gson
5. okhttp3
6. glide
7. lifecycle

## How Scan System works. 

The scan system consited of two pars:
1. Image Send/Upload
2. Description Retrieval
What this means is that we split communication channel between android app and our VM in the backend into two separated API, one for POST the images and the other for GET the details about the images. The backend will be the one dealing with our ML functionalities which means our app doesn't need to worry about that.

### Image Send/Upload 
The images will be uploaded to 
```
http://34.101.140.28/api/v1/upload
```
and the response of this `POST` request will contain `id` for later use when we want to get the details on the location of the images. After our models predict the place those picture was taken.

### Description Retrieval
To retrieve the details about the location where the images were taken, we only need to make http `GET` request to
```
http://34.101.140.28/api/v1/${id}/detail
```
where the `id` was obtained in the previous step. The details will be in JSON format and after we parse it, we can show it in the app.
