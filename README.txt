It's simple SpringBoot application with entrypoint class test.task.gaswater.GaswaterApplication
PersonService has init method with adding few rows to DB for person with id = 1 and id = 2.

So u can call GET http://localhost:8080/api/v1/person/1/measurement for getting person's measurements (1 is path variable of person id)
And u can call PATCH http://localhost:8080/api/v1/person/1/measurement with body like
{
    "meter": 10.23,
    "type": "GAS"
}
for updating values for measurement