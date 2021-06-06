# hotel-review

1. This is a very basic micro service with Redis, JPA connectivity 

2. Endpoints in this service can consume both XML/JSON

3. Packaging is done as a war

### Health Metrics are provided here:

	- /actuator/health
	- /actuator/env
	- /actuator/metrics
	- /actuator/mappings
	- /actuator/conditions
	- /actuator/beans
	
### Basic Swagger Implementation is present

### Common APIs for Test Running

curl --request POST \
  --url http://localhost:8089/rating \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: b010a9fa-d8b6-6c51-85f5-d829eb7dc020' \
  --data '{"hotelId":3,"rating":4.7,"review":"GOOD","isAnonymous":true,"userName":"AKG"}'
  
  
curl --request GET \
  --url http://localhost:8089/rating/2 \
  --header 'cache-control: no-cache' \
  --header 'postman-token: 65b242b0-45de-c2f9-6d42-34e92cf674f2'
