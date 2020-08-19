# steps of find the bug
## start an empty dgraph database
Terminal A: `./dgraph zero`

Terminal B: `./alpha --lru_mb 1024`

## load data
```
cd data

../dgraph live -f mock.rdf -s mock.schema
```

## run findbug.gql

```
java -jar dgraph-1.0-SNAPSHOT.jar localhost 9080 findbug.gql 50 3
```

## what did my  dgraph-1.0-SNAPSHOT.jar do?
It take 5 arguments. 

dgraph-host dgraph-port filename-of-a-query  min-length  max-run-times

I check the length of response, so I can find it when the response is empty.

If the response is empty , the length of response is < than the min-lenth,

If the response is not empty, the length of response is > than the min-lenth.

