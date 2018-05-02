namespace ListenToThePlaceBackend.Models
{
    public class AudioTrackItem
    {
        public long Id { get; set; }
        public string Name { get; set; }
        public string Performer { get; set; }
        public double Latitude { get; set; }
        public double Longtitude { get; set; }
    }
}
