f = open("battletreestuff.txt", 'r')
o = open("battletreesetspt.txt", 'w')


ch=f.read(1)
while ch!='':
	if ord(ch)==ord(':') or ord(ch)==ord('-') or ord(ch)==ord(' ') or ord(ch)==10:
		o.write(ch)
	if ord(ch)>=ord('a') and ord(ch)<=ord('z'):
		o.write(ch)
	if ord(ch)>=ord('A') and ord(ch)<=ord('Z'):
		o.write(ch)
	ch=f.read(1)
f.close()
o.close()

f = open("battletreesetspt.txt",'r')
o = open("battletreesets.txt",'w')


item=False
end=False
line=f.readline()
while line!="END":
	if line!="\n":
		o.write(line)
	if end:
		o.write("\n")
		end=False
		mon=True
	if item:
		item=False
		end=True
	if "Hold Item:" in line:
		item=True
	line=f.readline()

f.close()
o.close()


class Pokemon:
	def __init__(self, name, move1="", move2="", move3="", move4="", item=""):
		self.name = name
		self.move1 = move1
		self.move2 = move2
		self.move3 = move3
		self.move4 = move4
		self.item = item
	def setName(name):
		self.name = name
	def setMove(m, num):
		if num == 1:
			self.move1=m
		elif num == 2:
			self.move2=m
		elif num == 3:
			self.move3=m
		elif num == 4:
			self.move4=m
	def setItem(item):
		self.item=item
	def getName():
		return name
	def getMoves():
		return move1+" \r"+move2+" \r"+move3+" \r"+move4+" \r"
	def getItem():
		return item
