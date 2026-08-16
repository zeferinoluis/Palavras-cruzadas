package com.example.cruzadas.data.seed

import com.example.cruzadas.data.generator.CrosswordGenerator
import com.example.cruzadas.data.generator.CrosswordGenerator.CandidateWord
import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.models.Puzzle

object PrebuiltPuzzles {

    fun getInitialDictionaryWords(): List<DictionaryWord> {
        return listOf(
            // ==================== 1. PORTUGAL (HISTÓRIA E CULTURA) ====================
            DictionaryWord("Lisboa", "Capital de Portugal e cidade das sete colinas junto ao rio Tejo", "Portugal", "Fácil"),
            DictionaryWord("Bacalhau", "Prato de peixe seco tradicional da gastronomia portuguesa e consoada de Natal", "Portugal", "Fácil"),
            DictionaryWord("Pastel de Belém", "Doce conventual tradicional de massa folhada e creme nascido em Belém", "Portugal", "Fácil"),
            DictionaryWord("Fado", "Estilo musical tradicional português classificado Património Imaterial da Humanidade", "Portugal", "Fácil"),
            DictionaryWord("Mondego", "O rio mais longo que nasce em Portugal e desagua no Atlântico", "Portugal", "Fácil"),
            DictionaryWord("Sobreiro", "Árvore protegida em Portugal da qual se extrai a cortiça", "Portugal", "Fácil"),
            DictionaryWord("Açores", "Arquipélago português de nove ilhas vulcânicas no Oceano Atlântico", "Portugal", "Fácil"),
            DictionaryWord("Afonso Henriques", "Primeiro Rei e fundador da nacionalidade de Portugal (O Conquistador)", "Portugal", "Fácil"),
            DictionaryWord("Torre de Belém", "Monumento e fortaleza manuelina erguida no rio Tejo na Era dos Descobrimentos", "Portugal", "Fácil"),
            DictionaryWord("Madeira", "Maior ilha do arquipélago da Madeira, com capital no Funchal", "Portugal", "Fácil"),
            DictionaryWord("Galo de Barcelos", "Animal de barro colorido símbolo lendário do artesanato português", "Portugal", "Fácil"),
            DictionaryWord("Francesinha", "Sanduíche típico do Porto com carnes variadas, queijo e molho picante", "Portugal", "Fácil"),
            DictionaryWord("Serra da Estrela", "Cordilheira onde se situa o ponto mais alto de Portugal Continental (Torre)", "Portugal", "Fácil"),
            DictionaryWord("Coimbra", "Cidade universitária com a Queima das Fitas e uma das universidades mais antigas do mundo", "Portugal", "Fácil"),
            DictionaryWord("Atlântico", "Oceano que banha toda a costa de Portugal Continental e arquipélagos", "Portugal", "Fácil"),
            DictionaryWord("Santo António", "Santo popular festejado intensamente em Lisboa na noite de 12 para 13 de junho", "Portugal", "Fácil"),
            DictionaryWord("Poncha", "Bebida tradicional da Madeira com aguardente de cana, mel e limão", "Portugal", "Fácil"),
            DictionaryWord("Ovos Moles", "Famosa iguaria de ovos e açúcar típica da cidade de Aveiro", "Portugal", "Fácil"),
            DictionaryWord("Azulejos", "Tradicionais painéis de cerâmica pintados que decoram igrejas e edifícios em Portugal", "Portugal", "Fácil"),
            DictionaryWord("Vasco da Gama", "Navegador português que descobriu o caminho marítimo para a Índia em 1498", "Portugal", "Fácil"),
            DictionaryWord("Camões", "Poeta autor da célebre obra 'Os Lusíadas'", "Portugal", "Fácil"),
            DictionaryWord("Benfica", "Equipa de futebol de Lisboa com símbolo de águia que joga no Estádio da Luz", "Portugal", "Fácil"),
            DictionaryWord("Fátima", "Localidade onde ocorreram as aparições aos três pastorinhos em 1917", "Portugal", "Fácil"),
            DictionaryWord("Castanha", "Fruto seco assado tradicionalmente nas ruas no dia de São Martinho", "Portugal", "Fácil"),
            DictionaryWord("Cabo da Roca", "Cabo que marca o ponto mais ocidental de Portugal Continental e da Europa", "Portugal", "Fácil"),
            DictionaryWord("Pena", "Palácio romântico e colorido situado no topo da Serra de Sintra", "Portugal", "Fácil"),
            DictionaryWord("Caldo Verde", "Sopa tradicional portuguesa de puré de batata com couve-galega cortada fina", "Portugal", "Fácil"),
            DictionaryWord("Cristiano Ronaldo", "Futebolista português com cinco Bolas de Ouro nascido no Funchal", "Portugal", "Fácil"),
            DictionaryWord("Terramoto", "Grande sismo que destruiu Lisboa no ano de 1755", "Portugal", "Fácil"),
            DictionaryWord("Douro", "Grande rio vinícola que desagua na cidade do Porto", "Portugal", "Fácil"),
            DictionaryWord("Minho", "Região verdejante a norte famosa pelo vinho verde e folclore", "Portugal", "Fácil"),
            DictionaryWord("Algarve", "Região a sul de Portugal famosa pelas praias e falésias douradas", "Portugal", "Fácil"),
            DictionaryWord("Alentejo", "Vasta planície a sul do Tejo famosa pelo calor, azeite e montado", "Portugal", "Fácil"),
            DictionaryWord("Caravela", "Embarcação icónica e ligeira utilizada na Era dos Descobrimentos", "Portugal", "Fácil"),

            // Portugal Médio
            DictionaryWord("República", "Regime político implantado em Portugal a 5 de Outubro de 1910", "Portugal", "Médio"),
            DictionaryWord("Tratado de Zamora", "Tratado de 1143 que reconheceu a independência de Portugal face a Leão", "Portugal", "Médio"),
            DictionaryWord("Álvaro de Campos", "Heterónimo futurista e engenheiro naval de Fernando Pessoa", "Portugal", "Médio"),
            DictionaryWord("Eça de Queirós", "Escritor realista autor de romances célebres como 'Os Maias'", "Portugal", "Médio"),
            DictionaryWord("Aljubarrota", "Batalha travada em 1385 que consolidou a independência frente a Castela", "Portugal", "Médio"),
            DictionaryWord("Canhão da Nazaré", "Desfiladeiro submarino responsável pelas ondas gigantes mundiais na Nazaré", "Portugal", "Médio"),
            DictionaryWord("Rainha Santa", "Rainha D. Isabel de Aragão canonizada e lembrada pelo Milagre das Rosas", "Portugal", "Médio"),
            DictionaryWord("Salazar", "Ditador que governou o regime do Estado Novo em Portugal até 1968", "Portugal", "Médio"),
            DictionaryWord("Braga", "Cidade dos Arcebispos que alberga o santuário do Bom Jesus do Monte", "Portugal", "Médio"),
            DictionaryWord("Goa", "Antiga colónia portuguesa na Índia integrada na União Indiana em 1961", "Portugal", "Médio"),
            DictionaryWord("Manuelino", "Estilo arquitetónico tipicamente português com exuberantes motivos marítimos", "Portugal", "Médio"),
            DictionaryWord("Magalhães", "Navegador que liderou a primeira circum-navegação do globo", "Portugal", "Médio"),
            DictionaryWord("Mirandês", "Segunda língua oficial de Portugal falada no nordeste transmontano", "Portugal", "Médio"),
            DictionaryWord("Amália Rodrigues", "Fadista consagrada internacionalmente como a 'Rainha do Fado'", "Portugal", "Médio"),
            DictionaryWord("Tordesilhas", "Tratado de 1494 que dividiu as terras descobertas entre Portugal e Castela", "Portugal", "Médio"),
            DictionaryWord("Alqueva", "O maior lago artificial da Europa Ocidental no rio Guadiana", "Portugal", "Médio"),
            DictionaryWord("Marquês de Pombal", "Estadista que chefiou a reconstrução da Baixa de Lisboa após 1755", "Portugal", "Médio"),
            DictionaryWord("Rabanadas", "Doce tradicional natalício de pão frito passado por leite, ovo e açúcar", "Portugal", "Médio"),
            DictionaryWord("Amadeo", "Pintor pioneiro do modernismo português (Amadeo de Souza-Cardoso)", "Portugal", "Médio"),
            DictionaryWord("Manuel II", "O último rei de Portugal antes da implantação da República", "Portugal", "Médio"),
            DictionaryWord("Saramago", "Escritor português que venceu o Prémio Nobel da Literatura em 1998", "Portugal", "Médio"),
            DictionaryWord("Tratado de Windsor", "Tratado de 1386 que estabeleceu a aliança perpétua entre Portugal e Inglaterra", "Portugal", "Médio"),
            DictionaryWord("Touriga Nacional", "Principal casta de uva nobre utilizada no Vinho do Porto e vinhos do Douro", "Portugal", "Médio"),
            DictionaryWord("Guimarães", "Cidade Berço onde nasceu a nacionalidade e D. Afonso Henriques", "Portugal", "Médio"),
            DictionaryWord("São Jorge", "Castelo histórico no topo da colina mais alta de Lisboa", "Portugal", "Médio"),
            DictionaryWord("Nuno Álvares", "O Santo Condestável que comandou os portugueses na Batalha de Aljubarrota", "Portugal", "Médio"),
            DictionaryWord("Montanha do Pico", "O ponto de maior altitude de todo o território português nos Açores", "Portugal", "Médio"),
            DictionaryWord("Infante Henrique", "O Navegador, grande patrono dos Descobrimentos a partir de Sagres", "Portugal", "Médio"),
            DictionaryWord("Restauração", "Revolta patriótica de 1 de Dezembro de 1640 que restaurou a independência", "Portugal", "Médio"),
            DictionaryWord("Funchal", "Capital e principal cidade do arquipélago da Madeira", "Portugal", "Médio"),
            DictionaryWord("PIDE", "Polícia política repressiva durante o Estado Novo em Portugal", "Portugal", "Médio"),

            // Portugal Difícil
            DictionaryWord("Alcanizes", "Tratado de 1297 entre D. Dinis e Castela que fixou as fronteiras nacionais", "Portugal", "Difícil"),
            DictionaryWord("Fernão Lopes", "Pai da historiografia portuguesa e cronista-mor da Torre do Tombo", "Portugal", "Difícil"),
            DictionaryWord("Regicídio", "Atentado de 1908 no Terreiro do Paço que vitimou o Rei D. Carlos I", "Portugal", "Difícil"),
            DictionaryWord("Paula Rego", "Artista plástica portuguesa radicada em Londres célebre pela série 'Mulher Cão'", "Portugal", "Difícil"),
            DictionaryWord("São Mamede", "Batalha de 1128 em Guimarães considerada o marco fundacional da nação", "Portugal", "Difícil"),
            DictionaryWord("Ordem de Cister", "Primeira ordem religiosa a fixar-se no imponente Mosteiro de Alcobaça", "Portugal", "Difícil"),
            DictionaryWord("Eduardo Lourenço", "Ensaísta e filósofo autor de 'O Labirinto da Saudade'", "Portugal", "Difícil"),
            DictionaryWord("Francisco Sanches", "Filósofo e médico renascentista autor do tratado 'Que Nada se Sabe'", "Portugal", "Difícil"),
            DictionaryWord("Inês de Castro", "Nobre galega coroada rainha postumamente após o trágico amor com D. Pedro I", "Portugal", "Difícil"),
            DictionaryWord("Faial", "Ilha dos Açores onde ocorreu a erupção do Vulcão dos Capelinhos em 1957", "Portugal", "Difícil"),
            DictionaryWord("Aristides", "Diplomata em Bordéus que salvou milhares de refugiados na II Guerra Mundial", "Portugal", "Difícil"),
            DictionaryWord("Torres Vedras", "Linhas militares defensivas secretas que travaram as invasões francesas", "Portugal", "Difícil"),
            DictionaryWord("Mário Cesariny", "Poeta surrealista autor de 'A Faca Não Corta o Fogo'", "Portugal", "Difícil"),
            DictionaryWord("Pedro Nunes", "Matemático e cosmógrafo quinhentista português inventor do nónio", "Portugal", "Difícil"),
            DictionaryWord("Cadeia da Relação", "Antigo tribunal e prisão do Porto onde esteve detido Camilo Castelo Branco", "Portugal", "Difícil"),
            DictionaryWord("Tratado de Lisboa", "Tratado de 1668 entre Portugal e Espanha que encerrou a Guerra da Restauração", "Portugal", "Difícil"),
            DictionaryWord("Sagres", "Fortaleza algarvia historicamente ligada à navegação henriquina", "Portugal", "Difícil"),
            DictionaryWord("Gil Vicente", "Dramaturgo quinhentista considerado o Pai do Teatro Português", "Portugal", "Difícil"),
            DictionaryWord("Manifestis", "Bula papal Manifestis Probatum de 1179 que reconheceu o reino de Portugal", "Portugal", "Difícil"),
            DictionaryWord("Maria da Fonte", "Revolução popular e absolutista iniciada no Minho em 1846", "Portugal", "Difícil"),

            // ==================== 2. GEOGRAFIA ====================
            DictionaryWord("Camberra", "Capital federal da Austrália", "Geografia", "Médio"),
            DictionaryWord("Pacífico", "O maior e mais profundo oceano do planeta Terra", "Geografia", "Médio"),
            DictionaryWord("Tamisa", "Rio que atravessa a cidade de Londres", "Geografia", "Médio"),
            DictionaryWord("Rússia", "O país mais populoso e extenso do continente europeu", "Geografia", "Médio"),
            DictionaryWord("Saara", "O maior deserto quente do mundo situado no continente africano", "Geografia", "Médio"),
            DictionaryWord("Helsínquia", "Capital da Finlândia banhada pelo mar Báltico", "Geografia", "Médio"),
            DictionaryWord("Canadá", "País norte-americano que possui a maior linha de costa do mundo", "Geografia", "Médio"),
            DictionaryWord("Sicília", "A maior ilha do Mar Mediterrâneo, pertencente à Itália", "Geografia", "Médio"),
            DictionaryWord("Montes Urais", "Cordilheira de montanhas que separa a Europa da Ásia", "Geografia", "Médio"),
            DictionaryWord("Luanda", "Capital e principal cidade de Angola", "Geografia", "Médio"),
            DictionaryWord("Espanha", "País ibérico vizinho que faz fronteira terrestre com Portugal", "Geografia", "Fácil"),
            DictionaryWord("França", "País da Europa Ocidental com capital em Paris", "Geografia", "Fácil"),
            DictionaryWord("Brasil", "O maior país da América do Sul onde se fala português", "Geografia", "Fácil"),
            DictionaryWord("Roma", "Capital histórica da Itália e cidade eterna", "Geografia", "Fácil"),
            DictionaryWord("Alpes", "Imponente cordilheira montanhosa no centro da Europa", "Geografia", "Fácil"),
            DictionaryWord("Brunei", "País que partilha a ilha de Bornéu com a Malásia e a Indonésia", "Geografia", "Difícil"),
            DictionaryWord("Suriname", "O país menos populoso da América do Sul", "Geografia", "Difícil"),
            DictionaryWord("Chile", "País sul-americano onde se situa o árido deserto de Atacama", "Geografia", "Difícil"),
            DictionaryWord("Marianas", "Fossa oceânica que é o ponto mais profundo conhecido na Terra", "Geografia", "Difícil"),
            DictionaryWord("Ulan Bator", "Capital da Mongólia", "Geografia", "Difícil"),
            DictionaryWord("Gibraltar", "Estreito marítimo que separa o continente europeu de Marrocos", "Geografia", "Difícil"),
            DictionaryWord("Cazaquistão", "O maior país do mundo sem acesso direto ao mar", "Geografia", "Difícil"),
            DictionaryWord("Sena", "Rio histórico que corre pela cidade de Paris", "Geografia", "Difícil"),
            DictionaryWord("Monte Etna", "O vulcão ativo mais alto do continente europeu", "Geografia", "Difícil"),

            // ==================== 3. ENTRETENIMENTO ====================
            DictionaryWord("James Cameron", "Cineasta que realizou o filme épico e oscarizado 'Titanic' em 1997", "Entretenimento", "Médio"),
            DictionaryWord("Guerra dos Tronos", "Série televisiva da HBO mais premiada da história dos Emmys", "Entretenimento", "Médio"),
            DictionaryWord("Johnny Depp", "Ator que interpretou o capitão Jack Sparrow em Piratas das Caraíbas", "Entretenimento", "Médio"),
            DictionaryWord("Madonna", "Cantora e ícone da música pop aclamada como Rainha do Pop", "Entretenimento", "Médio"),
            DictionaryWord("Pink Floyd", "Banda britânica de rock que lançou o álbum 'The Dark Side of the Moon'", "Entretenimento", "Médio"),
            DictionaryWord("George Lucas", "Cineasta pioneiro criador da célebre saga espacial 'Star Wars'", "Entretenimento", "Médio"),
            DictionaryWord("Tom Hanks", "Ator protagonista de 'Forrest Gump' e 'O Náufrago'", "Entretenimento", "Médio"),
            DictionaryWord("Rihanna", "Cantora pop mundialmente aclamada com nacionalidade de Barbados", "Entretenimento", "Médio"),
            DictionaryWord("Trilogia", "Conjunto de três filmes que formam a saga original de O Senhor dos Anéis", "Entretenimento", "Médio"),
            DictionaryWord("ABBA", "Grupo pop sueco que venceu o Festival da Eurovisão em 1974 com 'Waterloo'", "Entretenimento", "Médio"),
            DictionaryWord("Cinema", "A sétima arte da exibição de filmes no grande ecrã", "Entretenimento", "Fácil"),
            DictionaryWord("Televisão", "Meio de comunicação de difusão de programas e séries", "Entretenimento", "Fácil"),
            DictionaryWord("Música", "Arte de combinar sons e ritmos harmoniosos", "Entretenimento", "Fácil"),
            DictionaryWord("Novela", "Narrativa ficcional transmitida em episódios diários na TV", "Entretenimento", "Fácil"),
            DictionaryWord("Wings", "Filme mudo de 1927 que venceu o primeiro Óscar de Melhor Filme em 1929", "Entretenimento", "Difícil"),
            DictionaryWord("Hitchcock", "Mestre do suspense que realizou a obra-prima 'Psicose' em 1960", "Entretenimento", "Difícil"),
            DictionaryWord("Buggles", "Banda de 'Video Killed the Radio Star', o primeiro videoclipe da MTV", "Entretenimento", "Difícil"),
            DictionaryWord("Springfield", "Cidade fictícia onde se desenrola o enredo de 'Os Simpsons'", "Entretenimento", "Difícil"),
            DictionaryWord("Audrey Hepburn", "Atriz que protagonizou o clássico 'Boneca de Luxo' (Breakfast at Tiffany's)", "Entretenimento", "Difícil"),
            DictionaryWord("Beatles", "Banda britânica de Liverpool formada por 4 membros originais", "Entretenimento", "Difícil"),
            DictionaryWord("Hans Zimmer", "Compositor germânico da banda sonora de 'O Rei Leão' e 'Gladiador'", "Entretenimento", "Difícil"),
            DictionaryWord("La Casa de Papel", "Série de televisão espanhola sobre assaltos de enorme sucesso mundial", "Entretenimento", "Difícil"),
            DictionaryWord("Toy Story", "Primeira longa-metragem de animação 3D por computador da Pixar", "Entretenimento", "Difícil"),
            DictionaryWord("Heath Ledger", "Ator que interpretou magistralmente o Joker em 'O Cavaleiro das Trevas'", "Entretenimento", "Difícil"),

            // ==================== 4. HISTÓRIA ====================
            DictionaryWord("George Washington", "Primeiro Presidente da história dos Estados Unidos da América", "História", "Médio"),
            DictionaryWord("Revolução dos Cravos", "Movimento de 25 de Abril de 1974 que restaurou a democracia em Portugal", "História", "Médio"),
            DictionaryWord("Egípcia", "Civilização antiga que construiu as imponentes pirâmides de Gizé", "História", "Médio"),
            DictionaryWord("Napoleão", "Imperador dos franceses derrotado na Batalha de Waterloo em 1815", "História", "Médio"),
            DictionaryWord("Revolução Francesa", "Movimento revolucionário de 1789 que aboliu a monarquia absoluta", "História", "Médio"),
            DictionaryWord("Adolf Hitler", "Ditador que chefiou a Alemanha nazi na Segunda Guerra Mundial", "História", "Médio"),
            DictionaryWord("Waterloo", "Batalha decisiva de 1815 que marcou o fim da era napoleónica", "História", "Médio"),
            DictionaryWord("Império", "Conjunto de povos e territórios governados por um soberano", "História", "Fácil"),
            DictionaryWord("Coroa", "Ornamento real usado na cabeça e símbolo da monarquia", "História", "Fácil"),
            DictionaryWord("Século", "Período histórico de cem anos consecutivos", "História", "Fácil"),
            DictionaryWord("Cruzadas", "Expedições militares medievais para recuperar a Terra Santa", "História", "Fácil"),
            DictionaryWord("Rainha Vitória", "Monarca britânica que reinou durante o apogeu do Império Britânico", "História", "Difícil"),
            DictionaryWord("Lenine", "Líder bolchevique da Revolução Russa de 1917 e fundador da URSS", "História", "Difícil"),
            DictionaryWord("Carta Magna", "Histórico documento de 1215 que limitou os poderes da monarquia em Inglaterra", "História", "Difícil"),
            DictionaryWord("Nicolau II", "O último czar da Rússia antes da Revolução de 1917", "História", "Difícil"),
            DictionaryWord("Guerra Civil", "Conflito armado interno norte-americano que terminou em 1865", "História", "Difícil"),
            DictionaryWord("Dinastia Qin", "Dinastia que governava a China no início da Grande Muralha", "História", "Difícil"),
            DictionaryWord("Inca", "Civilização andina pré-colombiana que construiu a cidadela de Machu Picchu", "História", "Difícil"),
            DictionaryWord("César Augusto", "Primeiro imperador de Roma e sobrinho de Júlio César", "História", "Difícil"),

            // ==================== 5. ARTES E LITERATURA ====================
            DictionaryWord("Miguel Ângelo", "Escultor e pintor renascentista que pintou o teto da Capela Sistina", "Artes e Literatura", "Médio"),
            DictionaryWord("Shakespeare", "Dramaturgo inglês que escreveu a célebre tragédia 'Romeu e Julieta'", "Artes e Literatura", "Médio"),
            DictionaryWord("Principezinho", "O clássico livro infantil de Saint-Exupéry mais traduzido após a Bíblia", "Artes e Literatura", "Médio"),
            DictionaryWord("Leonardo da Vinci", "Génio renascentista italiano que pintou a enigmática 'Mona Lisa'", "Artes e Literatura", "Médio"),
            DictionaryWord("Cubismo", "Vanguarda artística geométrica celebrizada por Pablo Picasso", "Artes e Literatura", "Médio"),
            DictionaryWord("Cervantes", "Escritor espanhol autor do romance 'Dom Quixote de la Mancha'", "Artes e Literatura", "Médio"),
            DictionaryWord("Edvard Munch", "Pintor expressionista norueguês que pintou o famoso quadro 'O Grito'", "Artes e Literatura", "Médio"),
            DictionaryWord("Rowling", "Escritora britânica que concebeu a saga literária 'Harry Potter'", "Artes e Literatura", "Médio"),
            DictionaryWord("Pintura", "Arte de aplicar pigmentos coloridos sobre uma superfície plana", "Artes e Literatura", "Fácil"),
            DictionaryWord("Soneto", "Forma poética clássica de 14 versos distribuídos em duas quadras e dois tercetos", "Artes e Literatura", "Fácil"),
            DictionaryWord("Teatro", "Arte performativa de representação dramática em palco perante público", "Artes e Literatura", "Fácil"),
            DictionaryWord("Guernica", "Famoso painel monumental de Picasso sobre a destruição da guerra", "Artes e Literatura", "Difícil"),
            DictionaryWord("Ricardo Reis", "Heterónimo clássico de Fernando Pessoa de profissão médica", "Artes e Literatura", "Difícil"),
            DictionaryWord("Dante", "Poeta florentino que escreveu a monumental 'Divina Comédia'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Auguste Rodin", "Escultor francês mestre da icónica escultura 'O Pensador'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Museu do Louvre", "Museu em Paris onde repousa a escultura clássica da Vénus de Milo", "Artes e Literatura", "Difícil"),
            DictionaryWord("Dostoiévski", "Romancista russo mestre da literatura autor de 'Crime e Castigo'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Estilo Gótico", "Estilo arquitetónico medieval com arcos ogivais e rosáceas de Notre-Dame", "Artes e Literatura", "Difícil"),
            DictionaryWord("García Márquez", "Escritor colombiano Nobel do realismo mágico autor de 'Cem Anos de Solidão'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Florbela Espanca", "Poetisa portuguesa apaixonada e sonetista de Vila Viçosa", "Artes e Literatura", "Difícil"),

            // ==================== 6. CIÊNCIAS E NATUREZA ====================
            DictionaryWord("Mercúrio", "O planeta do Sistema Solar mais próximo do Sol", "Ciências e Natureza", "Médio"),
            DictionaryWord("Esqueleto", "Conjunto de 206 ossos que sustenta o corpo humano adulto", "Ciências e Natureza", "Médio"),
            DictionaryWord("Oxigénio", "Gás indispensável à respiração dos seres humanos e animais", "Ciências e Natureza", "Médio"),
            DictionaryWord("Júpiter", "O maior planeta gasoso de todo o Sistema Solar", "Ciências e Natureza", "Médio"),
            DictionaryWord("Albert Einstein", "Físico teórico genial que formulou a Teoria da Relatividade", "Ciências e Natureza", "Médio"),
            DictionaryWord("Velocidade da Luz", "Velocidade cósmica de cerca de trezentos mil quilómetros por segundo", "Ciências e Natureza", "Médio"),
            DictionaryWord("Botânica", "Ramo da biologia que se dedica ao estudo rigoroso das plantas", "Ciências e Natureza", "Médio"),
            DictionaryWord("Lua", "O único satélite natural em órbita do planeta Terra", "Ciências e Natureza", "Médio"),
            DictionaryWord("Água", "Fórmula química H2O essencial à sustentação de todas as espécies", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Célula", "A unidade biológica fundamental de todos os organismos vivos", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Sol", "A estrela central que aquece e ilumina o Sistema Solar", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Fígado", "A maior glândula e órgão metabólico do corpo humano", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Tabela Periódica", "Quadro sistemático com 118 elementos químicos conhecidos", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Gravidade", "Força fundamental da física que mantém os planetas em órbita solar", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Fleming", "Cientista escocês que descobriu o antibiótico penicilina em 1928", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Crusta", "Camada rochosa externa e sólida que recobre a Terra", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Glóbulos", "Glóbulos vermelhos do sangue que transportam oxigénio aos tecidos", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Saturno", "Planeta gasoso célebre pelo espetacular sistema de anéis concêntricos", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Ohm", "Unidade padrão do Sistema Internacional que mede a resistência elétrica", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Charles Darwin", "Naturalista britânico que formulou a evolução por seleção natural", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Baleia-azul", "O maior animal e mamífero vivo do planeta Terra", "Ciências e Natureza", "Difícil"),

            // ==================== 7. DESPORTO E LAZER ====================
            DictionaryWord("Futebol", "Desporto coletivo rei disputado por 11 jogadores de cada lado", "Desporto e Lazer", "Médio"),
            DictionaryWord("Jogos Olímpicos", "Maior celebração desportiva mundial realizada de quatro em quatro anos", "Desporto e Lazer", "Médio"),
            DictionaryWord("Badminton", "Desporto com raquetes e um volante que se rebate sobre a rede", "Desporto e Lazer", "Médio"),
            DictionaryWord("Judô", "Arte marcial japonesa e modalidade desportiva olímpica de combate", "Desporto e Lazer", "Médio"),
            DictionaryWord("Camisola Amarela", "Camisola envergada pelo líder geral do Tour de France", "Desporto e Lazer", "Médio"),
            DictionaryWord("Cinco Anéis", "Símbolo gráfico dos Jogos Olímpicos representando os continentes", "Desporto e Lazer", "Médio"),
            DictionaryWord("Basquetebol", "Modalidade de cesto jogada por astros como LeBron James", "Desporto e Lazer", "Médio"),
            DictionaryWord("Bowling", "Jogo de precisão onde se atira uma bola pesada para derrubar 10 pinos", "Desporto e Lazer", "Médio"),
            DictionaryWord("Golfe", "Desporto jogado com tacos e bolas pequenas em campos relvados", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Natação", "Desporto aquático de deslocação rápida na água em piscinas", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Ténis", "Desporto de raquete jogado em court individual ou pares", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Usain Bolt", "Velocista jamaicano detentor do recorde mundial dos 100 metros rasos", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Atenas", "Cidade grega que acolheu os primeiros Jogos Olímpicos modernos em 1896", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Grand Slam", "Conjunto dos quatro torneios de elite do circuito internacional de ténis", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Larry O'Brien", "Troféu concedido à equipa campeã anual da liga de basquetebol da NBA", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Maratona", "Mítica prova de corrida pedestre com extensão oficial de 42,195 km", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Taça Davis", "Prestigiada competição anual de seleções nacionais de ténis masculino", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Ayrton Senna", "Piloto lendário brasileiro tricampeão mundial de Fórmula 1", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Capoeira", "Arte marcial e manifestação acrobática cultural originária do Brasil", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Dardos", "Jogo de pontaria no qual a pontuação máxima em três tiros é de 180 pontos", "Desporto e Lazer", "Difícil"),

            // ==================== 8. SAÚDE E CORPO ====================
            DictionaryWord("Dente", "Estrutura dura da boca usada para mastigar", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Osso", "Parte rígida do esqueleto", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Pele", "O maior órgão do corpo humano", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Veia", "Vaso que transporta o sangue para o coração", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Sangue", "Líquido vital de cor vermelha", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Bucinador", "Músculo da bochecha auxiliar na mastigação", "Saúde e Corpo", "Médio"),
            DictionaryWord("Esmalte", "Camada externa protetora do dente", "Saúde e Corpo", "Médio"),
            DictionaryWord("Gengiva", "Tecido mole que envolve a base dos dentes", "Saúde e Corpo", "Médio"),
            DictionaryWord("Sintoma", "Sinal indicador de uma patologia", "Saúde e Corpo", "Médio"),
            DictionaryWord("Artéria", "Vaso que leva o sangue oxigenado a partir do coração", "Saúde e Corpo", "Médio"),
            DictionaryWord("Diabetes", "Distúrbio metabólico caracterizado por glicemia elevada", "Saúde e Corpo", "Médio"),
            DictionaryWord("Glucose", "Principal açúcar simples que serve de energia celular", "Saúde e Corpo", "Médio"),
            DictionaryWord("Pulmão", "Órgão duplo torácico responsável pelas trocas gasosas", "Saúde e Corpo", "Médio"),
            DictionaryWord("Mitocôndria", "Organelo celular responsável pela respiração e produção de ATP", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Sarcoplasma", "O citoplasma das células musculares estriadas", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Anafilaxia", "Reação alérgica sistémica grave e potencialmente fatal", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Idiopático", "Diz-se de uma afeição de causa desconhecida ou espontânea", "Saúde e Corpo", "Difícil"),

            // ==================== 9. CULTURA GERAL ====================
            DictionaryWord("Jogo", "Atividade lúdica sujeita a regras estruturadas", "Cultura Geral", "Fácil"),
            DictionaryWord("Casa", "Edifício destinado a habitação humana", "Cultura Geral", "Fácil"),
            DictionaryWord("Luz", "Radiação eletromagnética visível pelo olho", "Cultura Geral", "Fácil"),
            DictionaryWord("Livro", "Conjunto encadernado de páginas impressas", "Cultura Geral", "Médio"),
            DictionaryWord("Regra", "Preceito ou norma que dita como se deve agir", "Cultura Geral", "Médio"),
            DictionaryWord("Lógica", "Ramo da filosofia que estuda a validade do raciocínio", "Cultura Geral", "Médio"),
            DictionaryWord("Ciência", "Conhecimento sistemático baseado em observação e testes", "Cultura Geral", "Médio"),
            DictionaryWord("Política", "Arte ou ciência da governação e organização social", "Cultura Geral", "Médio"),
            DictionaryWord("Economia", "Ciência que estuda a produção e distribuição de bens", "Cultura Geral", "Médio"),
            DictionaryWord("Justiça", "Princípio moral que preconiza a equidade e o direito", "Cultura Geral", "Médio"),
            DictionaryWord("Filosofia", "Investigação sobre o conhecimento e existência", "Cultura Geral", "Médio"),
            DictionaryWord("Pragmático", "Focado nos objetivos práticos, utilidade e resultados reais", "Cultura Geral", "Difícil"),
            DictionaryWord("Resiliência", "Capacidade de superar a adversidade e adaptar-se à mudança", "Cultura Geral", "Difícil"),
            DictionaryWord("Nepotismo", "Favorecimento ilegal de familiares ou amigos em cargos de poder", "Cultura Geral", "Difícil"),
            DictionaryWord("Paradoxo", "Contradição aparente que desafia as leis da lógica tradicional", "Cultura Geral", "Difícil")
        )
    }

    fun getInitialPuzzles(): List<Puzzle> {
        val puzzles = mutableListOf<Puzzle>()

        fun addPrebuilt(
            id: String,
            title: String,
            difficulty: String,
            category: String,
            gridSize: Int,
            candidates: List<CandidateWord>
        ) {
            val p = CrosswordGenerator.generateCrossword(
                title = title,
                difficulty = difficulty,
                category = category,
                targetWidth = gridSize,
                targetHeight = gridSize,
                wordPool = candidates,
                customId = id
            )
            if (p != null) {
                puzzles.add(p)
            }
        }

        // ==================== 1. PORTUGAL ====================
        addPrebuilt(
            id = "portugal_facil",
            title = "Portugal - Símbolos e Tradições",
            difficulty = "Fácil",
            category = "Portugal",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Lisboa", "LISBOA", "Capital de Portugal à beira do Tejo", "Portugal"),
                CandidateWord("Fado", "FADO", "Estilo musical tradicional português", "Portugal"),
                CandidateWord("Douro", "DOURO", "Rio vinícola que desagua no Porto", "Portugal"),
                CandidateWord("Minho", "MINHO", "Região verdejante a norte de Portugal", "Portugal"),
                CandidateWord("Bacalhau", "BACALHAU", "Prato de peixe seco tradicional", "Portugal")
            )
        )

        addPrebuilt(
            id = "portugal_medio",
            title = "Portugal - História e Monumentos",
            difficulty = "Médio",
            category = "Portugal",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Coimbra", "COIMBRA", "Cidade universitária com o rio Mondego", "Portugal"),
                CandidateWord("Guimarães", "GUIMARAES", "Cidade Berço onde nasceu a nação", "Portugal"),
                CandidateWord("Manuelino", "MANUELINO", "Estilo arquitetónico marítimo luso", "Portugal"),
                CandidateWord("Algarve", "ALGARVE", "Região a sul famosa pelas praias", "Portugal"),
                CandidateWord("Alentejo", "ALENTEJO", "Planície a sul do Tejo com azeite", "Portugal"),
                CandidateWord("Azulejo", "AZULEJO", "Placa cerâmica tradicional lusa", "Portugal"),
                CandidateWord("Cortiça", "CORTICA", "Produto do sobreiro líder em Portugal", "Portugal"),
                CandidateWord("Caravela", "CARAVELA", "Navio da Era dos Descobrimentos", "Portugal")
            )
        )

        addPrebuilt(
            id = "portugal_dificil",
            title = "Portugal - Cultura e Herança Erudita",
            difficulty = "Difícil",
            category = "Portugal",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Vasco da Gama", "VASCO#DA#GAMA", "Navegador que descobriu o caminho marítimo para a Índia", "Portugal"),
                CandidateWord("Torre de Belém", "TORRE#DE#BELEM", "Monumento e fortaleza manuelina no rio Tejo", "Portugal"),
                CandidateWord("Aljubarrota", "ALJUBARROTA", "Batalha de 1385 que garantiu a independência", "Portugal"),
                CandidateWord("Francesinha", "FRANCESINHA", "Iguaria portuense de carnes e molho picante", "Portugal"),
                CandidateWord("Tordesilhas", "TORDESILHAS", "Tratado de 1494 que dividiu o Novo Mundo", "Portugal"),
                CandidateWord("Saramago", "SARAMAGO", "Prémio Nobel da Literatura português de 1998", "Portugal"),
                CandidateWord("Regicídio", "REGICIDIO", "Atentado de 1908 que vitimou o Rei D. Carlos I", "Portugal")
            )
        )

        // ==================== 2. GEOGRAFIA ====================
        addPrebuilt(
            id = "geografia_facil",
            title = "Geografia - Países e Continentes",
            difficulty = "Fácil",
            category = "Geografia",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Espanha", "ESPANHA", "País ibérico que faz fronteira com Portugal", "Geografia"),
                CandidateWord("França", "FRANCA", "País europeu com capital em Paris", "Geografia"),
                CandidateWord("Brasil", "BRASIL", "Maior país da América do Sul de língua portuguesa", "Geografia"),
                CandidateWord("Roma", "ROMA", "Capital histórica da Itália", "Geografia"),
                CandidateWord("Alpes", "ALPES", "Cordilheira montanhosa no centro da Europa", "Geografia")
            )
        )

        addPrebuilt(
            id = "geografia_medio",
            title = "Geografia - Capitais e Mares do Mundo",
            difficulty = "Médio",
            category = "Geografia",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Camberra", "CAMBERRA", "Capital da Austrália", "Geografia"),
                CandidateWord("Pacífico", "PACIFICO", "O maior oceano do mundo", "Geografia"),
                CandidateWord("Tamisa", "TAMISA", "Rio que atravessa a cidade de Londres", "Geografia"),
                CandidateWord("Rússia", "RUSSIA", "O país mais populoso da Europa", "Geografia"),
                CandidateWord("Saara", "SAARA", "Maior deserto quente no continente africano", "Geografia"),
                CandidateWord("Sicília", "SICILIA", "A maior ilha do Mar Mediterrâneo", "Geografia"),
                CandidateWord("Canadá", "CANADA", "País com a maior linha de costa do mundo", "Geografia"),
                CandidateWord("Luanda", "LUANDA", "Capital de Angola", "Geografia")
            )
        )

        addPrebuilt(
            id = "geografia_dificil",
            title = "Geografia - Extremos e Relevos Globais",
            difficulty = "Difícil",
            category = "Geografia",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Cazaquistão", "CAZAQUISTAO", "Maior país do mundo sem acesso ao mar", "Geografia"),
                CandidateWord("Gibraltar", "GIBRALTAR", "Estreito que separa Espanha de Marrocos", "Geografia"),
                CandidateWord("Marianas", "MARIANAS", "Fossa mais profunda conhecida nos oceanos", "Geografia"),
                CandidateWord("Suriname", "SURINAME", "País menos populoso da América do Sul", "Geografia"),
                CandidateWord("Brunei", "BRUNEI", "País que partilha a ilha de Bornéu", "Geografia"),
                CandidateWord("Atacama", "ATACAMA", "Deserto árido situado no Chile", "Geografia"),
                CandidateWord("Helsínquia", "HELSINQUIA", "Capital da Finlândia banhada pelo Báltico", "Geografia")
            )
        )

        // ==================== 3. HISTÓRIA ====================
        addPrebuilt(
            id = "historia_facil",
            title = "História - Civilizações e Reis",
            difficulty = "Fácil",
            category = "História",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Império", "IMPERIO", "Conjunto de povos governados por um imperador", "História"),
                CandidateWord("Coroa", "COROA", "Símbolo e ornamento real de soberania", "História"),
                CandidateWord("Século", "SECULO", "Período histórico de cem anos", "História"),
                CandidateWord("Cruzadas", "CRUZADAS", "Expedições medievais à Terra Santa", "História"),
                CandidateWord("Castelo", "CASTELO", "Fortificação militar defensiva medieval", "História")
            )
        )

        addPrebuilt(
            id = "historia_medio",
            title = "História - Grandes Revoluções e Líderes",
            difficulty = "Médio",
            category = "História",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Napoleão", "NAPOLEAO", "Imperador francês derrotado em Waterloo", "História"),
                CandidateWord("Egípcia", "EGIPCIA", "Civilização que construiu as pirâmides de Gizé", "História"),
                CandidateWord("Waterloo", "WATERLOO", "Batalha decisiva de 1815 na Bélgica", "História"),
                CandidateWord("Cravos", "CRAVOS", "Símbolo da Revolução portuguesa de 1974", "História"),
                CandidateWord("Washington", "WASHINGTON", "Primeiro Presidente dos Estados Unidos", "História"),
                CandidateWord("Henriques", "HENRIQUES", "Primeiro rei de Portugal (D. Afonso)", "História"),
                CandidateWord("PIDE", "PIDE", "Polícia política da ditadura do Estado Novo", "História"),
                CandidateWord("Revolução", "REVOLUCAO", "Transformação radical política e social", "História")
            )
        )

        addPrebuilt(
            id = "historia_dificil",
            title = "História - Documentos e Dinastias Mundiais",
            difficulty = "Difícil",
            category = "História",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Carta Magna", "CARTA#MAGNA", "Documento de 1215 que limitou o poder real", "História"),
                CandidateWord("César Augusto", "CESAR#AUGUSTO", "Primeiro imperador do Império Romano", "História"),
                CandidateWord("Nicolau II", "NICOLAU#II", "Último czar da dinastia Romanov na Rússia", "História"),
                CandidateWord("Vitória", "VITORIA", "Rainha britânica no auge do Império no séc. XIX", "História"),
                CandidateWord("Lenine", "LENINE", "Líder da Revolução Russa e da URSS", "História"),
                CandidateWord("Dinastia", "DINASTIA", "Série de soberanos da mesma família", "História"),
                CandidateWord("Inca", "INCA", "Civilização que ergueu Machu Picchu", "História")
            )
        )

        // ==================== 4. ARTES E LITERATURA ====================
        addPrebuilt(
            id = "artes_facil",
            title = "Artes - Expressão e Criatividade",
            difficulty = "Fácil",
            category = "Artes e Literatura",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Poema", "POEMA", "Obra literária composta em versos", "Artes e Literatura"),
                CandidateWord("Pintura", "PINTURA", "Arte visual de aplicação de cor na tela", "Artes e Literatura"),
                CandidateWord("Teatro", "TEATRO", "Arte performativa de representação dramática", "Artes e Literatura"),
                CandidateWord("Soneto", "SONETO", "Poema clássico estruturado em 14 versos", "Artes e Literatura"),
                CandidateWord("Música", "MUSICA", "Arte de combinar sons e melodias", "Artes e Literatura")
            )
        )

        addPrebuilt(
            id = "artes_medio",
            title = "Artes - Grandes Mestres e Escritores",
            difficulty = "Médio",
            category = "Artes e Literatura",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Shakespeare", "SHAKESPEARE", "Dramaturgo inglês autor de 'Romeu e Julieta'", "Artes e Literatura"),
                CandidateWord("Camões", "CAMOES", "Maior poeta épico português de 'Os Lusíadas'", "Artes e Literatura"),
                CandidateWord("Cubismo", "CUBISMO", "Vanguarda artística celebrizada por Picasso", "Artes e Literatura"),
                CandidateWord("Cervantes", "CERVANTES", "Autor de 'Dom Quixote de la Mancha'", "Artes e Literatura"),
                CandidateWord("Munch", "MUNCH", "Pintor expressionista autor de 'O Grito'", "Artes e Literatura"),
                CandidateWord("Rowling", "ROWLING", "Autora britânica criadora de Harry Potter", "Artes e Literatura"),
                CandidateWord("Romance", "ROMANCE", "Narrativa literária longa com enredo rico", "Artes e Literatura"),
                CandidateWord("Harmonia", "HARMONIA", "Combinação agradável de acordes musicais", "Artes e Literatura")
            )
        )

        addPrebuilt(
            id = "artes_dificil",
            title = "Artes - Obras-Primas e Estética",
            difficulty = "Difícil",
            category = "Artes e Literatura",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Guernica", "GUERNICA", "Célebre pintura de Picasso sobre a guerra", "Artes e Literatura"),
                CandidateWord("Dostoiévski", "DOSTOIEVSKI", "Romancista russo de 'Crime e Castigo'", "Artes e Literatura"),
                CandidateWord("Gótico", "GOTICO", "Estilo arquitetónico de Notre-Dame de Paris", "Artes e Literatura"),
                CandidateWord("Florbela", "FLORBELA", "Poetisa alentejana dos célebres sonetos", "Artes e Literatura"),
                CandidateWord("Louvre", "LOUVRE", "Museu parisiense da estátua da Vénus de Milo", "Artes e Literatura"),
                CandidateWord("Dante", "DANTE", "Poeta florentino autor da 'Divina Comédia'", "Artes e Literatura"),
                CandidateWord("Rodin", "RODIN", "Escultor francês mestre da estátua 'O Pensador'", "Artes e Literatura")
            )
        )

        // ==================== 5. CIÊNCIAS E NATUREZA ====================
        addPrebuilt(
            id = "ciencias_facil",
            title = "Ciências - O Universo e a Vida",
            difficulty = "Fácil",
            category = "Ciências e Natureza",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Água", "AGUA", "Fórmula H2O indispensável a todas as vidas", "Ciências e Natureza"),
                CandidateWord("Célula", "CELULA", "Unidade estrutural fundamental da vida", "Ciências e Natureza"),
                CandidateWord("Sol", "SOL", "Estrela central brilhante do nosso sistema", "Ciências e Natureza"),
                CandidateWord("Lua", "LUA", "O satélite natural que orbita a Terra", "Ciências e Natureza"),
                CandidateWord("Planeta", "PLANETA", "Corpo celeste que orbita em torno do Sol", "Ciências e Natureza")
            )
        )

        addPrebuilt(
            id = "ciencias_medio",
            title = "Ciências - Sistema Solar e Elementos",
            difficulty = "Médio",
            category = "Ciências e Natureza",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Mercúrio", "MERCURIO", "Planeta mais próximo do Sol no Sistema Solar", "Ciências e Natureza"),
                CandidateWord("Oxigénio", "OXIGENIO", "Gás vital para a respiração humana", "Ciências e Natureza"),
                CandidateWord("Júpiter", "JUPITER", "O maior planeta de todo o Sistema Solar", "Ciências e Natureza"),
                CandidateWord("Einstein", "EINSTEIN", "Físico que formulou a Teoria da Relatividade", "Ciências e Natureza"),
                CandidateWord("Botânica", "BOTANICA", "Ciência biológica dedicada ao estudo das plantas", "Ciências e Natureza"),
                CandidateWord("Esqueleto", "ESQUELETO", "Estrutura de 206 ossos do corpo humano", "Ciências e Natureza"),
                CandidateWord("Atmosfera", "ATMOSFERA", "Camada gasosa protetora da Terra", "Ciências e Natureza"),
                CandidateWord("Mineral", "MINERAL", "Substância natural sólida inorgânica", "Ciências e Natureza")
            )
        )

        addPrebuilt(
            id = "ciencias_dificil",
            title = "Ciências - Fisiologia e Descobertas",
            difficulty = "Difícil",
            category = "Ciências e Natureza",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Baleia Azul", "BALEIA#AZUL", "O maior animal e mamífero vivo do planeta Terra", "Ciências e Natureza"),
                CandidateWord("Gravidade", "GRAVIDADE", "Força atrativa que mantém órbitas planetárias", "Ciências e Natureza"),
                CandidateWord("Fleming", "FLEMING", "Descobriu o antibiótico penicilina em 1928", "Ciências e Natureza"),
                CandidateWord("Saturno", "SATURNO", "Planeta conhecido pelo sistema de anéis", "Ciências e Natureza"),
                CandidateWord("Darwin", "DARWIN", "Propôs a evolução por seleção natural", "Ciências e Natureza"),
                CandidateWord("Fígado", "FIGADO", "A maior glândula metabólica do corpo humano", "Ciências e Natureza"),
                CandidateWord("Fotossíntese", "FOTOSSINTESE", "Conversão de luz em energia pelas plantas", "Ciências e Natureza")
            )
        )

        // ==================== 6. ENTRETENIMENTO ====================
        addPrebuilt(
            id = "entretenimento_facil",
            title = "Entretenimento - Cinema e TV",
            difficulty = "Fácil",
            category = "Entretenimento",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Cinema", "CINEMA", "A sétima arte da exibição de filmes", "Entretenimento"),
                CandidateWord("Música", "MUSICA", "Arte de combinar ritmos e canções", "Entretenimento"),
                CandidateWord("Televisão", "TELEVISAO", "Aparelho de emissão de séries e notícias", "Entretenimento"),
                CandidateWord("Novela", "NOVELA", "Trama ficcional televisiva em episódios", "Entretenimento"),
                CandidateWord("Filme", "FILME", "Obra cinematográfica para tela ou streaming", "Entretenimento")
            )
        )

        addPrebuilt(
            id = "entretenimento_medio",
            title = "Entretenimento - Estrelas e Séries",
            difficulty = "Médio",
            category = "Entretenimento",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Cameron", "CAMERON", "Realizou o clássico oscarizado 'Titanic'", "Entretenimento"),
                CandidateWord("Madonna", "MADONNA", "Consagrada mundialmente como Rainha do Pop", "Entretenimento"),
                CandidateWord("Pink Floyd", "PINKFLOYD", "Banda de 'The Dark Side of the Moon'", "Entretenimento"),
                CandidateWord("George Lucas", "GEORGELUCAS", "Cineasta criador da saga 'Star Wars'", "Entretenimento"),
                CandidateWord("Tom Hanks", "TOMHANKS", "Ator que protagonizou 'Forrest Gump'", "Entretenimento"),
                CandidateWord("Rihanna", "RIHANNA", "Cantora pop mundial natural de Barbados", "Entretenimento"),
                CandidateWord("Trilogia", "TRILOGIA", "Série de 3 filmes em 'O Senhor dos Anéis'", "Entretenimento"),
                CandidateWord("ABBA", "ABBA", "Grupo sueco vencedor da Eurovisão com 'Waterloo'", "Entretenimento")
            )
        )

        addPrebuilt(
            id = "entretenimento_dificil",
            title = "Entretenimento - Clássicos e Prémios de Culto",
            difficulty = "Difícil",
            category = "Entretenimento",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Hitchcock", "HITCHCOCK", "Realizador do clássico de terror 'Psicose'", "Entretenimento"),
                CandidateWord("Beatles", "BEATLES", "Banda de rock britânica com 4 membros", "Entretenimento"),
                CandidateWord("Toy Story", "TOYSTORY", "Primeira longa-metragem animada da Pixar", "Entretenimento"),
                CandidateWord("Springfield", "SPRINGFIELD", "Cidade fictícia onde se passa 'Os Simpsons'", "Entretenimento"),
                CandidateWord("Ledger", "LEDGER", "Ator que interpretou o Joker em 2008", "Entretenimento"),
                CandidateWord("Zimmer", "ZIMMER", "Compositor da banda sonora de 'O Rei Leão'", "Entretenimento"),
                CandidateWord("Wings", "WINGS", "Filme vencedor do 1º Óscar de Melhor Filme", "Entretenimento")
            )
        )

        // ==================== 7. DESPORTO E LAZER ====================
        addPrebuilt(
            id = "desporto_facil",
            title = "Desporto - Jogos e Modalidades",
            difficulty = "Fácil",
            category = "Desporto e Lazer",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Golfe", "GOLFE", "Desporto jogado com tacos e bolas no relvado", "Desporto e Lazer"),
                CandidateWord("Natação", "NATACAO", "Desporto aquático de deslocação em piscina", "Desporto e Lazer"),
                CandidateWord("Ténis", "TENIS", "Modalidade de raquete jogada em court", "Desporto e Lazer"),
                CandidateWord("Futebol", "FUTEBOL", "Desporto de 11 jogadores por equipa", "Desporto e Lazer"),
                CandidateWord("Bola", "BOLA", "Objeto esférico essencial a vários desportos", "Desporto e Lazer")
            )
        )

        addPrebuilt(
            id = "desporto_medio",
            title = "Desporto - Campeonatos e Atletas",
            difficulty = "Médio",
            category = "Desporto e Lazer",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Olímpicos", "OLIMPICOS", "Jogos mundiais disputados de 4 em 4 anos", "Desporto e Lazer"),
                CandidateWord("Ronaldo", "RONALDO", "Astro português vencedor de 5 Bolas de Ouro", "Desporto e Lazer"),
                CandidateWord("Badminton", "BADMINTON", "Desporto de raquete onde se usa um volante", "Desporto e Lazer"),
                CandidateWord("Judô", "JUDO", "Arte marcial japonesa de combate", "Desporto e Lazer"),
                CandidateWord("Basquetebol", "BASQUETEBOL", "Desporto de cesto do astro LeBron James", "Desporto e Lazer"),
                CandidateWord("Bowling", "BOWLING", "Jogo de precisão para derrubar 10 pinos", "Desporto e Lazer"),
                CandidateWord("Amarela", "AMARELA", "Camisola do líder geral no Tour de France", "Desporto e Lazer"),
                CandidateWord("Anéis", "ANEIS", "Símbolo dos cinco continentes olímpicos", "Desporto e Lazer")
            )
        )

        addPrebuilt(
            id = "desporto_dificil",
            title = "Desporto - Recordes e Lendas Globais",
            difficulty = "Difícil",
            category = "Desporto e Lazer",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Maratona", "MARATONA", "Prova de corrida oficial com 42,195 km", "Desporto e Lazer"),
                CandidateWord("Ayrton Senna", "AYRTONSENNA", "Piloto brasileiro tricampeão de Fórmula 1", "Desporto e Lazer"),
                CandidateWord("Usain Bolt", "USAINBOLT", "Recordista mundial nos 100 metros rasos", "Desporto e Lazer"),
                CandidateWord("Capoeira", "CAPOEIRA", "Arte marcial e dança acrobática do Brasil", "Desporto e Lazer"),
                CandidateWord("Grand Slam", "GRANDSLAM", "Conjunto dos 4 maiores torneios de ténis", "Desporto e Lazer"),
                CandidateWord("Atenas", "ATENAS", "Cidade dos primeiros Jogos Olímpicos modernos", "Desporto e Lazer"),
                CandidateWord("Taça Davis", "TACADAVIS", "Prestigiada taça entre seleções de ténis", "Desporto e Lazer")
            )
        )

        // ==================== 8. SAÚDE E CORPO ====================
        addPrebuilt(
            id = "saude_facil",
            title = "Saúde - Corpo e Sinais",
            difficulty = "Fácil",
            category = "Saúde e Corpo",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Dente", "DENTE", "Estrutura dura da boca usada para mastigar", "Saúde e Corpo"),
                CandidateWord("Osso", "OSSO", "Parte rígida do esqueleto", "Saúde e Corpo"),
                CandidateWord("Pele", "PELE", "O maior órgão do corpo humano", "Saúde e Corpo"),
                CandidateWord("Veia", "VEIA", "Vaso que transporta o sangue para o coração", "Saúde e Corpo"),
                CandidateWord("Sangue", "SANGUE", "Líquido vital de cor vermelha", "Saúde e Corpo")
            )
        )

        addPrebuilt(
            id = "saude_medio",
            title = "Saúde - Anatomia e Medicina",
            difficulty = "Médio",
            category = "Saúde e Corpo",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Bucinador", "BUCINADOR", "Músculo da bochecha auxiliar na mastigação", "Saúde e Corpo"),
                CandidateWord("Esmalte", "ESMALTE", "Camada externa protetora do dente", "Saúde e Corpo"),
                CandidateWord("Gengiva", "GENGIVA", "Tecido mole que envolve a base dos dentes", "Saúde e Corpo"),
                CandidateWord("Sintoma", "SINTOMA", "Sinal indicador de uma patologia", "Saúde e Corpo"),
                CandidateWord("Artéria", "ARTERIA", "Vaso que leva o sangue oxigenado", "Saúde e Corpo"),
                CandidateWord("Diabetes", "DIABETES", "Distúrbio metabólico de glicemia", "Saúde e Corpo"),
                CandidateWord("Glucose", "GLUCOSE", "Principal açúcar simples de energia", "Saúde e Corpo"),
                CandidateWord("Pulmão", "PULMAO", "Órgão responsável pelas trocas gasosas", "Saúde e Corpo")
            )
        )

        addPrebuilt(
            id = "saude_dificil",
            title = "Saúde - Fisiologia Erudita",
            difficulty = "Difícil",
            category = "Saúde e Corpo",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Mitocôndria", "MITOCONDRIA", "Organelo responsável pela respiração celular", "Saúde e Corpo"),
                CandidateWord("Sarcoplasma", "SARCOPLASMA", "O citoplasma das células musculares", "Saúde e Corpo"),
                CandidateWord("Anafilaxia", "ANAFILAXIA", "Reação alérgica sistémica grave", "Saúde e Corpo"),
                CandidateWord("Idiopático", "IDIOPATICO", "Diz-se de afeição de causa desconhecida", "Saúde e Corpo")
            )
        )

        // ==================== 9. CULTURA GERAL ====================
        addPrebuilt(
            id = "geral_facil",
            title = "Cultura Geral - Conceitos Básicos",
            difficulty = "Fácil",
            category = "Cultura Geral",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Jogo", "JOGO", "Atividade lúdica sujeita a regras", "Cultura Geral"),
                CandidateWord("Casa", "CASA", "Edifício destinado a habitação", "Cultura Geral"),
                CandidateWord("Luz", "LUZ", "Radiação eletromagnética visível", "Cultura Geral"),
                CandidateWord("Livro", "LIVRO", "Conjunto encadernado de páginas", "Cultura Geral"),
                CandidateWord("Regra", "REGRA", "Preceito que dita como agir", "Cultura Geral")
            )
        )

        addPrebuilt(
            id = "geral_medio",
            title = "Cultura Geral - Sociedade e Saberes",
            difficulty = "Médio",
            category = "Cultura Geral",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Lógica", "LOGICA", "Ramo da filosofia sobre o raciocínio", "Cultura Geral"),
                CandidateWord("Ciência", "CIENCIA", "Conhecimento baseado em testes e factos", "Cultura Geral"),
                CandidateWord("História", "HISTORIA", "Estudo e registo das ações humanas", "Cultura Geral"),
                CandidateWord("Política", "POLITICA", "Arte da governação e organização social", "Cultura Geral"),
                CandidateWord("Economia", "ECONOMIA", "Estudo da produção e distribuição de bens", "Cultura Geral"),
                CandidateWord("Justiça", "JUSTICA", "Princípio moral de equidade e direito", "Cultura Geral"),
                CandidateWord("Filosofia", "FILOSOFIA", "Investigação sobre conhecimento e existência", "Cultura Geral")
            )
        )

        addPrebuilt(
            id = "geral_dificil",
            title = "Cultura Geral - Vocabulário Erudito",
            difficulty = "Difícil",
            category = "Cultura Geral",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Pragmático", "PRAGMATICO", "Focado nos objetivos práticos e utilidade", "Cultura Geral"),
                CandidateWord("Resiliência", "RESILIENCIA", "Capacidade de superar a adversidade", "Cultura Geral"),
                CandidateWord("Nepotismo", "NEPOTISMO", "Favorecimento ilegal de familiares em cargos", "Cultura Geral"),
                CandidateWord("Paradoxo", "PARADOXO", "Contradição aparente que desafia a lógica", "Cultura Geral")
            )
        )

        return puzzles
    }
}

