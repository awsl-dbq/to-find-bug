const fs = require('fs')
var lines = fs.readFileSync('./seeds.rdf').toString().split('\n')
function takeUid(line) {
    var idx = line.indexOf('<APP#')
    return line.substring(0, idx)
}
function mock(uid, key, idx) {
    console.log(uid, `<APP#usersettings/${key}>`, `"${idx}_key@app.to.findbug.com"^^<xs:string> .`)
}
var i = 0;
for (var line of lines) {
    var uid = takeUid(line)
    console.log(line)
    mock(uid, 'alias', i)
    mock(uid, 'email', i)
    mock(uid, 'userId', i)
    mock(uid, 'nickname', i)
    i++;
}

// node buildmockdatafromseed.js > mock.rdf