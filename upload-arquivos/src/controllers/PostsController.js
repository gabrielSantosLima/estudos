const Post = require('../models/Post')
const fs = require('fs')
const path = require('path')

module.exports = {
    async post(req, resp){
        const { originalname: name, size, path: dir, filename: key } = req.file

        const newPost = new Post({
            name,
            size,
            key,
            dir
        })

        await newPost.save()
        
        return resp.json(newPost)
    },

    async get(req, resp){
        const posts = await Post.find()
        return resp.json(posts) 
    },
    async deleteAll(req, resp){
        const tmpPath = path.resolve(__dirname, '..', '..', 'tmp')
        
        await Post.deleteMany()
        
        await fs.rmdirSync(tmpPath, { force: true, recursive: true })
        await fs.mkdirSync(tmpPath)
        
        return resp.status(200).json({ message: 'Todas as postagens foram deletadas!' })
    }
}