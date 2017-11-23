get "/" do |ctx|
  ctx.response.content_type = "text/plain"
  "Hello, Auth0!"
end