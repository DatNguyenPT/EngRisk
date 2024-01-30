import mysql.connector
import json

# Connect to MySQL
connection = mysql.connector.connect(
    host='localhost',
    user='root',
    password='28102004',
    database='ENGRISK',
    auth_plugin='mysql_native_password'
)

# Open and read the JSON file
file_path = r'C:\Users\Hii\Desktop\Side Projects\EngrRisk\EngRisk\src\main\resources\Data.json'
with open(file_path) as f:
    json_data = json.load(f)

# Create SQL INSERT statement
sql = "INSERT INTO VOCAB (category, words, word_type, pronoun, example_sentence) VALUES (%s, %s, %s, %s, %s)"

# Execute the INSERT statement for each JSON object
check = True  # Initialize check flag
try:
    cursor = connection.cursor()
    for item in json_data:
        category = item['category']
        words = item['words']
        wordType = item['wordType']
        pronoun = item['pronoun']
        exampleSentence = item['exampleSentence']
        try:
            cursor.execute(sql, (category, words, wordType, pronoun, exampleSentence))
            check = True
        except mysql.connector.Error as error:
            check = False  # Set check flag to False if an error occurs
            print("Error inserting JSON data:", error)  # Print error message
    connection.commit()
    if check:
        print("JSON data inserted successfully!")
finally:
    # Close the connection
    if connection.is_connected():
        cursor.close()
        connection.close()
        print("MySQL connection closed.")
