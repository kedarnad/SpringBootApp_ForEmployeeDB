import requests
import json
#creating a Test case for getting the present Employee:

#url for getting an Employee Request:
url= "http://localhost:8080/employee/c0c2293d-16bd-4603-8e08-638a9d18b22c"
recieve = requests.get(url)
print("Getting one of the current Employees :")
print(recieve.text)


#URL for Creating a new Employee Result:
print('Creating a new Employee record')
payload = {
		    "employeeId": "a7839310-3348-423b-a7e3-5ge1f157beb3",
		    "firstName": "kedar_new",
		    "lastName": "Nad",
		    "position": "Developer III",
		    "department": "Engineering"
		}

URL = "http://localhost:8080/employee/"
newHeaders = {'Content-type': 'application/json'}
recieve = requests.post(URL, data=json.dumps(payload), headers=newHeaders)
print("updating a new Employee")
print(recieve.status_code)
print(recieve.json())

print("\n############################################################################")

# creating a multi structured user:
print('Creating a new Multi-Level Employee record')
payload = {
		    "employeeId": "aXYZdwdwd310-3348-423b-a7e3-5ge1f157beb3",
		    "firstName": "JaySon",
		    "lastName": "Bridget",
		    "position": "Developer III",
		    "department": "Engineering",
            "directReports" : [
                {
                     "employeeId" : "329sdahd-6e34-4630-93fd-9153afb65309"
                 },
            {
            "employeeId": "c0c23476d-16bd-4603-8e08-638a9d18b22c",
            "directReports":[{
                 "employeeId" : "329sdahd-6e34-4630-93fd-jeaknjbdkejbfk"
            }]
            }
    ]
		}

URL = "http://localhost:8080/employee/"
newHeaders = {'Content-type': 'application/json'}
recieve = requests.post(URL, data=json.dumps(payload), headers=newHeaders)
print("updating a new Employee")
print(recieve.status_code)
print(recieve.json())
# updated_data=recieve.json()
# print(updated_data['employeeId'])


print("\n############################################################################")
print("Printing the Custom made Direct Report Records ")
print("\nChecking the number of Employee Direct Report Records for the custom records created in the JSON file:")
empId =""
url= "http://localhost:8080/reportingStruct/"+"aXYZ310-3348-423b-a7e3-5ge1f157beb3"
print("url",url)
recieve = requests.get(url)
print("Getting one of the current Employees :")
print(recieve.status_code)
print(recieve.text)


print("Printing the Given Direct Report Records ")
print("\nChecking the number of Employee Direct Report Records:")
empId =""
url= "http://localhost:8080/reportingStruct/"+"16a596ae-edd3-4847-99fe-c4518e82c86f"
print("url",url)
recieve = requests.get(url)
print("Getting one of the current Employees :")
print(recieve.status_code)
print(recieve.text)





print("\n############################################################################")
print("\nCreating Structure for the Compensation")
payload ={
        "employee": {
            "employeeId": "SoftDev_kn9936",
            "firstName": "Kedar",
            "lastName": "Nadkarni",
            "position": "Developer II",
            "department": "Engineering"
        },
        "salary": 200000,
        "effectiveDate": "10-10-2020"
    }

URL="http://localhost:8080/compensation/create"
newHeaders = {'Content-type': 'application/json'}
recieve = requests.post(URL, data=json.dumps(payload), headers=newHeaders)
print("Compensation Record Created...")
print("Status Code: ",recieve.status_code)
print(recieve.json())



print("\nRetrieving the compensation created: ")
url= "http://localhost:8080/compensation/read/SoftDev_kn9936"
print("url",url)
recieve = requests.get(url)
print("Compensation for one of the employees:")
print(recieve.status_code)
print(recieve.text)



print("\nCreating Structure for the Another Employee Compensation")
payload ={
        "employee": {
            "employeeId": "SoftDev_atv6565",
            "firstName": "Gopi",
            "lastName": "Swami",
            "position": "System Architect",
            "department": "Engineering"
        },
        "salary": 200000,
        "effectiveDate": "10-10-2020"
    }

URL="http://localhost:8080/compensation/create"
newHeaders = {'Content-type': 'application/json'}
recieve = requests.post(URL, data=json.dumps(payload), headers=newHeaders)
print("Compensation Record Created...")
print("Status Code: ",recieve.status_code)
print(recieve.json())



print("\nRetrieving the compensation for SoftDev_atv6565: ")
url= "http://localhost:8080/compensation/read/SoftDev_atv6565"
print("url",url)
recieve = requests.get(url)
print("Compensation for one of the employees:")
print(recieve.status_code)
print(recieve.text)