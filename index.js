const express = require('express')

const app = express()

app.get('/', (req, resp)=> {
    return resp.json({
        hello: 'world',
        timestamp: new Date().toUTCString()
    })
})

app.use(express.json())
app.listen(3000)