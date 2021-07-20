const Post = require('../models/Post')

module.exports = {
    async post(req, resp){
        const { originalname: name, size, path: dir, filename: key } = req.file

        const post = await Post.create({
            name,
            size,
            key,
            dir
        })
        
        return resp.json(post)
    }
}