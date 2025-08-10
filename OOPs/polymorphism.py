# Polymorphism Example
# Demonstrates: Method overriding, interface implementation, duck typing

class Shape:
    """Abstract base class for shapes"""
    
    def area(self):
        """Abstract method - should be implemented by subclasses"""
        pass
    
    def perimeter(self):
        """Abstract method - should be implemented by subclasses"""
        pass
    
    def describe(self):
        """Common method for all shapes"""
        return f"This is a {self.__class__.__name__}"

class Circle(Shape):
    """Circle class implementing Shape interface"""
    
    def __init__(self, radius):
        self.radius = radius
    
    def area(self):
        """Calculate circle area"""
        import math
        return math.pi * self.radius ** 2
    
    def perimeter(self):
        """Calculate circle perimeter (circumference)"""
        import math
        return 2 * math.pi * self.radius
    
    def describe(self):
        """Override describe method"""
        return f"This is a Circle with radius {self.radius}"

class Rectangle(Shape):
    """Rectangle class implementing Shape interface"""
    
    def __init__(self, length, width):
        self.length = length
        self.width = width
    
    def area(self):
        """Calculate rectangle area"""
        return self.length * self.width
    
    def perimeter(self):
        """Calculate rectangle perimeter"""
        return 2 * (self.length + self.width)
    
    def describe(self):
        """Override describe method"""
        return f"This is a Rectangle with length {self.length} and width {self.width}"

class Triangle(Shape):
    """Triangle class implementing Shape interface"""
    
    def __init__(self, base, height, side1, side2):
        self.base = base
        self.height = height
        self.side1 = side1
        self.side2 = side2
    
    def area(self):
        """Calculate triangle area"""
        return 0.5 * self.base * self.height
    
    def perimeter(self):
        """Calculate triangle perimeter"""
        return self.base + self.side1 + self.side2
    
    def describe(self):
        """Override describe method"""
        return f"This is a Triangle with base {self.base} and height {self.height}"

# Polymorphism with different media players
class MediaPlayer:
    """Base class for media players"""
    
    def play(self):
        pass
    
    def pause(self):
        pass
    
    def stop(self):
        pass

class AudioPlayer(MediaPlayer):
    """Audio player implementation"""
    
    def __init__(self, audio_file):
        self.audio_file = audio_file
        self.is_playing = False
    
    def play(self):
        self.is_playing = True
        return f"Playing audio: {self.audio_file}"
    
    def pause(self):
        self.is_playing = False
        return f"Paused audio: {self.audio_file}"
    
    def stop(self):
        self.is_playing = False
        return f"Stopped audio: {self.audio_file}"

class VideoPlayer(MediaPlayer):
    """Video player implementation"""
    
    def __init__(self, video_file):
        self.video_file = video_file
        self.is_playing = False
        self.current_time = 0
    
    def play(self):
        self.is_playing = True
        return f"Playing video: {self.video_file} at {self.current_time}s"
    
    def pause(self):
        self.is_playing = False
        return f"Paused video: {self.video_file} at {self.current_time}s"
    
    def stop(self):
        self.is_playing = False
        self.current_time = 0
        return f"Stopped video: {self.video_file}"

# Testing polymorphism
print("=== Polymorphism Example ===")

# Shape polymorphism
print("Shape Polymorphism:")
shapes = [
    Circle(5),
    Rectangle(4, 6),
    Triangle(3, 4, 5, 5)
]

for shape in shapes:
    print(f"\n{shape.describe()}")
    print(f"Area: {shape.area():.2f}")
    print(f"Perimeter: {shape.perimeter():.2f}")

# Media player polymorphism
print("\nMedia Player Polymorphism:")
players = [
    AudioPlayer("song.mp3"),
    VideoPlayer("movie.mp4")
]

for player in players:
    print(f"\n{player.__class__.__name__}:")
    print(player.play())
    print(player.pause())
    print(player.stop())

# Duck typing example
print("\n=== Duck Typing Example ===")

class Duck:
    def swim(self):
        return "Duck is swimming"
    
    def quack(self):
        return "Duck says quack!"

class RubberDuck:
    def swim(self):
        return "Rubber duck is floating"
    
    def quack(self):
        return "Rubber duck squeaks!"

def make_it_swim(duck_like_object):
    """Function that works with any object that has a swim method"""
    return duck_like_object.swim()

def make_it_quack(duck_like_object):
    """Function that works with any object that has a quack method"""
    return duck_like_object.quack()

# Both objects work with the same functions
real_duck = Duck()
rubber_duck = RubberDuck()

print(make_it_swim(real_duck))
print(make_it_quack(real_duck))
print(make_it_swim(rubber_duck))
print(make_it_quack(rubber_duck)) 