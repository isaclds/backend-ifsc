export async function helloWorld(req, res) {
  return res.status(200).send({ chave: "Hello World" });
}
