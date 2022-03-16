# tasks

---
Task 1

An application manages a list of tasks. Each task consists of a unique name and a list of the names of other tasks that need to be complete before it can be undertaken.

E.g.

fix bug 1 -> ()
fix bug 2 -> ()
refactor W -> ()
implement feature X -> ( fix bug 2 , refactor W )
release -> ( fix bug 1 , fix bug 2 , implement feature X )
deploy -> ( release )

The number of tasks and the number of dependencies in a task is only bound by the limits of the programming language/library (i.e. the limits for Collections in Java). The graph formed by the tasks is acyclic and directed so no task can depend on itself either directly or indirectly.

Given a Map<String, Set<String>> of task definitions, write a function that returns a list of all task names in an order that ensures that all dependencies for a task n occur before that task n in the list.

The function must adhere to the following declaration


List<String> sort(Map<String, Set<String>> tasks);
Upload your solution to task here
No file chosen
---
Task 2

Now it is time to add a UI for your outstanding task-sorting application.
The same rules apply as mentioned above(unique name, etc.).

Please add a UI (angular) that can:
display a list of tasks in correct order (data source can be the fixed list mentioned below; no need to re-implement the sorting algorithm or fetch the list dynamically)
the list entry is prefixed with the type of task(ie. [BUG],[IMPR])
the footer shows the sum of tasks by type
each entry has a checkbox to indicate if a task has been completed. if this is checked the corresponding row should be marked and it should not contribute to the sum in the footer
basic styling is enough(design is not the main objective here…)
once you are done please zip the folder (node_modules can be removed) and upload the zip

const tasks = JSON.parse(`[{"type":"BUG","name":"fix bug1","deps":[]},{"type":"BUG","name":"fix bug2","deps":[]},{"type":"IMPR","name":"refactor W","deps":[]},{"type":"IMPL","name":"implement feature X","deps":["fix bug2","refactor W"]},{"type":"INFRA","name":"release","deps":["fix bug1","fix bug2","implement feature X"]},{"type":"INFRA","name":"deploy","deps":["release"]}]`)

---
Task 3

What chain of events happens when an http client sends a GET request to an URL like https://www.example.com/index.html?ts=1537437557&m=foo#chapter1 (i.e. the URL is entered into the address bar of a browser and the user presses enter).
Assume the target server is reachable and returns an HTML page. Please give an overview of operations done by the client, the server and the network in between and go into details as you deem relevant.

#Neo4J

docker run \
--publish=7474:7474 --publish=7687:7687 \
--volume=$HOME/neo4j/data:/data \
neo4j

defaultUser: neo4j
defaultPass: neo4j
user: neo4j
pass: admin
url: localhost:7474/browser

run both commands to erase db:

match (a) -[r] -> () delete a, r

above command will delete all nodes with relationships. then run ,

match (a) delete a

and it will delete nodes that have no relationships.