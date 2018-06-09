# Deck of cards  


Simple deck of cards, made for fun. 

**POST /deck**
create a new deck. Will return id of the deck  

```json
{
	"Id": 4,
	"CardCount": 52,
	"cards": [...]
}
```

**POST /deck/{id}/deal**
    return the first card of the deck  
    if empty return http 204 (NO CONTENT)

**GET /deck/{id}**
    FOR TEST ONLY - return current state of the deck

**POST /deck/{id}/shuffle**
    shuffle all the cards
    return HTTP 201 (CREATED) with empty body
    


