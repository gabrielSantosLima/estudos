const routes = require('express').Router()
const multer = require('multer')

const multerConfig = require('./config/multer')

const ImageController = require('./controllers/ImageController')

routes.post('/uploads', multer(multerConfig).single('file'), ImageController.post)

module.exports = routes