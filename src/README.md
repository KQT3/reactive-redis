### https://www.youtube.com/watch?v=jgpVdJB2sKQ

```
docker exec -it 1e87449d3994 redis-cli

INFO
KEYS *
ttl com.example.reactiveredis.Article

SMEMBERS com.example.reactiveredis.Article

```
