const routes = require('express').Router()
const multer = require('multer')

const multerConfig = require('./config/multer')

const PostsController = require('./controllers/PostsController')

routes.post('/uploads', multer(multerConfig).single('file'), PostsController.post)
routes.get('/uploads', PostsController.get)
routes.delete('/uploads', PostsController.deleteAll)

module.exports = routes