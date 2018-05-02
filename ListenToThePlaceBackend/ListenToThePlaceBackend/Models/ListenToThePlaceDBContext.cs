using Microsoft.EntityFrameworkCore;

namespace ListenToThePlaceBackend.Models
{
    public class ListenToThePlaceDBContext : DbContext
    {
        public ListenToThePlaceDBContext(DbContextOptions<ListenToThePlaceDBContext> options)
            : base(options)
        { }

        public DbSet<AudioTrackItem> AudioTracks { get; set; }
    }
}
