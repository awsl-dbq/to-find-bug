## info
seeds.rdf is a part of data exported from the true environment of my application.
I use this as seeds to generate mock data for re-produce the bug I reported.  

## create mock data to live load into dgraph.

`node buildmockdatafromseed.js > mock.rdf`

## dgraph live 

`../dgraph live -f mock.rdf -s mock.schema`