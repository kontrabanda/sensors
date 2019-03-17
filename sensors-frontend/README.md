### Deployment

sudo docker build -t sensors_frontend .
sudo docker run -p 3300:3000 -v ~/develop/sensors/sensors-frontend:/app sensors_frontend
