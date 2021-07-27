const express = require('express')
const morgan = require('morgan')
const cors = require('cors')
const mongoose = require('mongoose')

const routes = require('./routes')

const app = express()

mongoose.connect('mongodb://localhost:27017/upload', { 
    useNewUrlParser: true,
    useUnifiedTopology: true
})

const db = mongoose.connection

db.on('error', () => { console.log('Falha na conexão!') })
db.once('open', () => { console.log('Conectado!') })

app.use(cors())
app.use(express.json())
app.use(morgan('dev'))
// lida com requisições no padrão url enconded (para o envio de imagens)
app.use(express.urlencoded({ extended: true }))
app.use(routes)

app.listen(3000)